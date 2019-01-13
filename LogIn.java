package CuoiKy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JPasswordField tfpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn;
	Statement stmt;
	void ConnectDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogIn.setBounds(217, 87, 101, 29);
		contentPane.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(114, 167, 104, 22);
		contentPane.add(lblUsername);
		
		tfuser = new JTextField();
		tfuser.setBounds(254, 170, 210, 22);
		contentPane.add(tfuser);
		tfuser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(114, 224, 104, 22);
		contentPane.add(lblPassword);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(254, 224, 210, 22);
		contentPane.add(tfpass);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBackground(Color.PINK);
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConnectDB();
					stmt = (Statement) conn.createStatement();
					PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM regist WHERE Username = ? AND Password = ? ");
					pstmt.setString(1, "tfuser");
					pstmt.setString(2, "tfpass");
					ResultSet rs = pstmt.executeQuery();
					int n = 0 ;
					while (rs.next())
					{
						n++;
					}
					if(n==0)
					{
						JOptionPane.showConfirmDialog(null, "Username and Password is correct");
					}
					else if(n>1)
					{
						JOptionPane.showConfirmDialog(null, "Duplicate UserName and Password");
						
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "UserName and Password is not correct");
					}
						conn.close();
						stmt.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogIn.setBounds(190, 279, 128, 37);
		contentPane.add(btnLogIn);
		
		JButton btnClickHereIf = new JButton("Click Here To Create New Account ");
		btnClickHereIf.setForeground(Color.BLACK);
		btnClickHereIf.setBackground(Color.PINK);
		btnClickHereIf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB();
					REGIST regist = new REGIST();
					regist.setVisible(true);
					regist.setLocationRelativeTo(null);
					regist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnClickHereIf.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnClickHereIf.setBounds(70, 367, 360, 25);
		contentPane.add(btnClickHereIf);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\Administrator-icon.png"));
		lblNewLabel.setBounds(53, 157, 32, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\padlock-lock-icon.png"));
		lblNewLabel_1.setBounds(53, 219, 32, 32);
		contentPane.add(lblNewLabel_1);
	}

}

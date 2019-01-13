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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class REGIST extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JPasswordField tfpass;
	private JTextField tfemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGIST frame = new REGIST();
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
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public REGIST() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegister.setBounds(254, 84, 104, 25);
		contentPane.add(lblRegister);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(91, 178, 111, 25);
		contentPane.add(lblUsername);
		
		tfuser = new JTextField();
		tfuser.setBounds(234, 182, 258, 22);
		contentPane.add(tfuser);
		tfuser.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(91, 233, 66, 25);
		contentPane.add(lblEmail);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(234, 293, 258, 22);
		contentPane.add(tfpass);
		
		JLabel lblNewLabel = new JLabel("Password\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 293, 111, 25);
		contentPane.add(lblNewLabel);
		
		tfemail = new JTextField();
		tfemail.setBounds(234, 237, 258, 22);
		contentPane.add(tfemail);
		tfemail.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(Color.PINK);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnRegister.setBounds(214, 371, 170, 35);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ConnectDB();					
					stmt = (Statement) conn.createStatement();
					int n = stmt.executeUpdate("INSERT into regist values ('"+tfuser.getText()+"','"+tfemail.getText()+"','"+tfpass.getText()+"')");
					if(n>0)
						JOptionPane.showConfirmDialog(null, "Done");
					else 
						JOptionPane.showConfirmDialog(null, "Fali");
					conn.close();
					stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}

			
		});
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\upload-icon.png"));
		lblNewLabel_1.setBounds(161, 67, 64, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\Administrator-icon.png"));
		lblNewLabel_2.setBounds(32, 177, 32, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\Mail-icon.png"));
		lblNewLabel_3.setBounds(32, 232, 32, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Hi-XV\\Downloads\\padlock-lock-icon.png"));
		lblNewLabel_4.setBounds(32, 288, 32, 32);
		contentPane.add(lblNewLabel_4);
	}
}

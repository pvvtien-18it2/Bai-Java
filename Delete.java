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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelete.setBounds(179, 13, 82, 35);
		contentPane.add(lblDelete);
		
		JLabel lblEnterIdYou = new JLabel("ENTER ID YOU WANT TO DELETE");
		lblEnterIdYou.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblEnterIdYou.setBounds(12, 77, 294, 22);
		contentPane.add(lblEnterIdYou);
		
		tfid = new JTextField();
		tfid.setBounds(304, 77, 116, 22);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDelete.setBounds(151, 138, 131, 25);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ConnectDB();
					stmt = (Statement) conn.createStatement();
					int n = stmt.executeUpdate("DELETE FROM info WHERE ID = '"+tfid.getText()+"'");
					if(n>0)
					{
						JOptionPane.showConfirmDialog(null, "Delete Success");
						ShowInfo show = new ShowInfo();
						show.setVisible(true);
						show.setLocationRelativeTo(null);
						show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
					}
					else 
					{
						JOptionPane.showConfirmDialog(null, "Fail");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
	}

}

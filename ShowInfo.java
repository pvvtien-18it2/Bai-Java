package CuoiKy;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ShowInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowInfo frame = new ShowInfo();
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/qlsv", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public ShowInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1174, 771);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentManagementProgram = new JLabel("STUDENT MANAGEMENT PROGRAM");
		lblStudentManagementProgram.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblStudentManagementProgram.setBounds(355, 63, 480, 59);
		contentPane.add(lblStudentManagementProgram);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.setBackground(Color.PINK);
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNew add = new AddNew();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddNew.setBounds(75, 138, 150, 33);
		contentPane.add(btnAddNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(Color.PINK);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Edit edit = new Edit();
					edit.setVisible(true);
					edit.setLocationRelativeTo(null);
					edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(355, 138, 150, 33);
		contentPane.add(btnEdit);
		
		JButton btndelete = new JButton("Delete");
		btndelete.setBackground(Color.PINK);
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btndelete.setBounds(635, 138, 150, 33);
		contentPane.add(btndelete);
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Delete delete = new Delete();
					delete.setVisible(true);
					delete.setLocationRelativeTo(null);
					delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		
		JButton btnShowInfo = new JButton("Show Info");
		btnShowInfo.setBackground(Color.PINK);
		btnShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectDB();
					PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM info");
					ResultSet rs = pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnShowInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnShowInfo.setBounds(915, 138, 150, 33);
		contentPane.add(btnShowInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 186, 1084, 525);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}

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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	Connection  conn;
	Statement  stmt;
	ButtonGroup bg;
	private JTextField tfname;
	private JTextField tfclass;
	private JTextField tfc;
	private JTextField tfjava;
	private JTextField tfcsdl;
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
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdit = new JLabel("EDIT");
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEdit.setBounds(260, 13, 123, 57);
		contentPane.add(lblEdit);
		
		JLabel lblEnterIdYou = new JLabel("ID");
		lblEnterIdYou.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterIdYou.setBounds(70, 100, 80, 22);
		contentPane.add(lblEnterIdYou);
		
		tfid = new JTextField();
		tfid.setBounds(192, 100, 308, 22);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(70, 140, 80, 22);
		contentPane.add(lblName);
		
		tfname = new JTextField();
		tfname.setBounds(192, 140, 308, 22);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(70, 180, 80, 22);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.PINK);
		rdbtnMale.setBounds(192, 180, 74, 22);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFamale = new JRadioButton("Famale");
		rdbtnFamale.setBackground(Color.PINK);
		rdbtnFamale.setBounds(282, 180, 74, 22);
		contentPane.add(rdbtnFamale);
		bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFamale);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClass.setBounds(70, 220, 56, 22);
		contentPane.add(lblClass);
		
		tfclass = new JTextField();
		tfclass.setBounds(192, 220, 308, 22);
		contentPane.add(tfclass);
		tfclass.setColumns(10);
		
		JLabel lblDiemc = new JLabel("DiemC");
		lblDiemc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemc.setBounds(70, 260, 80, 22);
		contentPane.add(lblDiemc);
		
		tfc = new JTextField();
		tfc.setBounds(192, 260, 308, 22);
		contentPane.add(tfc);
		tfc.setColumns(10);
		
		JLabel lblDiemjava = new JLabel("DiemJAVA");
		lblDiemjava.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemjava.setBounds(70, 300, 110, 22);
		contentPane.add(lblDiemjava);
		
		tfjava = new JTextField();
		tfjava.setBounds(192, 300, 308, 22);
		contentPane.add(tfjava);
		tfjava.setColumns(10);
		
		JLabel lblDiemcsdl = new JLabel("DiemCSDL");
		lblDiemcsdl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemcsdl.setBounds(70, 340, 110, 22);
		contentPane.add(lblDiemcsdl);
		
		tfcsdl = new JTextField();
		tfcsdl.setBounds(192, 340, 308, 22);
		contentPane.add(tfcsdl);
		tfcsdl.setColumns(10);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnEdit.setBounds(260, 396, 97, 25);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ConnectDB();
					String gt = "";
					if(rdbtnMale.isSelected())
					{
						gt = rdbtnMale.getText();
					}
					if(rdbtnFamale.isSelected())
					{
						gt = rdbtnFamale.getText();	
					}
					float c = Float.parseFloat(tfc.getText());
					float java = Float.parseFloat(tfjava.getText());
					float csdl = Float.parseFloat(tfcsdl.getText());
					float tb = (c+java+csdl)/3;
					stmt =(Statement) conn.createStatement();
					int n = stmt.executeUpdate("Update info set Name = '"+tfname.getText()+"',Gender = '"+gt+"',Class = '"+tfclass.getText()+"',DiemC = '"+tfc.getText()+"',DiemCSDL = '"+tfcsdl.getText()+"',DiemJava = '"+tfjava.getText()+"',DiemTB = '"+tb+"' WHERE ID = '"+tfid.getText()+"'");
					if(n>0)
					{
						JOptionPane.showConfirmDialog(null, "Edit Success");
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
					conn.close();
					stmt.close();
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		

	}
	}



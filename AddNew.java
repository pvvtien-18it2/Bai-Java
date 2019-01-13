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

public class AddNew extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfclass;
	private JTextField tfc;
	private JTextField tfjava;
	private JTextField tfcsdl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew frame = new AddNew();
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
	ButtonGroup bg;
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
	public AddNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNew = new JLabel("Add New");
		lblAddNew.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddNew.setBounds(245, 13, 117, 29);
		contentPane.add(lblAddNew);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(65, 60, 120, 22);
		contentPane.add(lblId);
		
		tfid = new JTextField();
		tfid.setBounds(211, 60, 295, 22);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblName.setBounds(65, 100, 120, 22);
		contentPane.add(lblName);
		
		tfname = new JTextField();
		tfname.setBounds(211, 100, 295, 22);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClass.setBounds(65, 180, 120, 22);
		contentPane.add(lblClass);
		
		tfclass = new JTextField();
		tfclass.setBounds(211, 180, 295, 22);
		contentPane.add(tfclass);
		tfclass.setColumns(10);
		
		JLabel lblDiemc = new JLabel("DiemC");
		lblDiemc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemc.setBounds(65, 220, 120, 22);
		contentPane.add(lblDiemc);
		
		tfc = new JTextField();
		tfc.setBounds(211, 220, 295, 22);
		contentPane.add(tfc);
		tfc.setColumns(10);
		
		JLabel lblDiemjava = new JLabel("DiemJava");
		lblDiemjava.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemjava.setBounds(65, 260, 120, 22);
		contentPane.add(lblDiemjava);
		
		tfjava = new JTextField();
		tfjava.setBounds(211, 260, 295, 22);
		contentPane.add(tfjava);
		tfjava.setColumns(10);
		
		JLabel lblDiemcsdl = new JLabel("DiemCSDL");
		lblDiemcsdl.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiemcsdl.setBounds(65, 300, 120, 22);
		contentPane.add(lblDiemcsdl);
		
		tfcsdl = new JTextField();
		tfcsdl.setBounds(211, 300, 295, 22);
		contentPane.add(tfcsdl);
		tfcsdl.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(65, 140, 120, 22);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.PINK);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMale.setBounds(210, 140, 71, 22);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFamale = new JRadioButton("Famale");
		rdbtnFamale.setBackground(Color.PINK);
		rdbtnFamale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFamale.setBounds(379, 140, 127, 22);
		contentPane.add(rdbtnFamale);
		bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFamale);
		
		JButton btnAddNow = new JButton("Add Now");
		btnAddNow.setBackground(Color.PINK);
		btnAddNow.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAddNow.setBounds(245, 344, 147, 29);
		btnAddNow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ConnectDB();
					String gt = "";
					if(rdbtnMale.isSelected())
					{
						gt= rdbtnMale.getText();
					}
					if(rdbtnFamale.isSelected())
						gt = rdbtnFamale.getText();
					float c = Float.parseFloat(tfc.getText());
					float java = Float.parseFloat(tfjava.getText());
					float csdl = Float.parseFloat(tfcsdl.getText());
					float tb = (c+java+csdl)/3;
					
					stmt = (Statement) conn.createStatement();
					int n = stmt.executeUpdate("Insert into info values ('"+tfid.getText()+"','"+tfname.getText()+"','"+gt+"','"+tfclass.getText()+"','"+tfc.getText()+"','"+tfjava.getText()+"','"+tfcsdl.getText()+"','"+tb+"')");
					if(n>0)
					{
						JOptionPane.showConfirmDialog(null, "Insert Success");
						ShowInfo showinfo = new ShowInfo();
						showinfo.setVisible(true);
						showinfo.setLocationRelativeTo(null);
						showinfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
					}
					else 
					{
						JOptionPane.showConfirmDialog(null, "Fail");
					}
					conn.close();
					stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(btnAddNow);
		
		
	}
}

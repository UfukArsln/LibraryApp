package pck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddUserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	
	ArrayList<User> user = new ArrayList<User>();
	DatabaseCon dbCon = new DatabaseCon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserPage frame = new AddUserPage();
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
	public AddUserPage() {
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 11, 65, 23);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(84, 12, 91, 20);
		contentPane.add(txtName);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(10, 45, 65, 23);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 46, 91, 20);
		contentPane.add(txtEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 79, 65, 23);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(84, 80, 91, 20);
		contentPane.add(txtPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 113, 65, 23);
		contentPane.add(lblRole);
		
		JComboBox cbRole = new JComboBox();
		cbRole.addItem("admin");
		cbRole.addItem("normal");
		cbRole.setBounds(84, 114, 91, 20);
		contentPane.add(cbRole);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user = new User();
				user.setEmail(txtEmail.getText());
				user.setName(txtName.getText());
				user.setPassword(txtPassword.getText());
				user.setRole(cbRole.getSelectedItem().toString());
				
				try {
					dbCon.saveUser(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(84, 193, 91, 23);
		contentPane.add(btnSave);
	}
}

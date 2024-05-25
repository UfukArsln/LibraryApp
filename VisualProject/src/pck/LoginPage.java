package pck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMail;
	private JTextField txtPassword;
	
	public int userId=0;
	
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 30, 84, 29);
		contentPane.add(lblNewLabel);
		
		txtMail = new JTextField();
		txtMail.setBounds(116, 30, 126, 29);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(10, 82, 107, 29);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(116, 82, 126, 29);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtMail.getText(); 
				String password = txtPassword.getText();
				
				
				DatabaseCon dbCon = new DatabaseCon();
				try {
					if(dbCon.getUsers().stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password) && user.getRole().equals("admin")).findFirst().isPresent()) {
						
							AdminPage adminPage = new AdminPage();
							adminPage.setVisible(true);
						
					}else if(dbCon.getUsers().stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password) && user.getRole().equals("normal")).findFirst().isPresent()) {
						
						userId= dbCon.getUsers().stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password) && user.getRole().equals("normal")).findFirst().get().getUserId();
						LoginUserInfo.getInstance().setUserID(userId);
						UserPage userPage = new UserPage();
						userPage.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "User Not Found !");
					}
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(116, 135, 126, 29);
		contentPane.add(btnLogin);
	}
}

package pck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddBookPage bookPage = new AddBookPage();
				bookPage.setVisible(true);
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBook.setBounds(10, 131, 126, 29);
		contentPane.add(btnAddBook);
		
		JButton btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddAuthorPage authorPage = new AddAuthorPage();
				authorPage.setVisible(true);
			}
		});
		btnAddAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddAuthor.setBounds(10, 79, 126, 29);
		contentPane.add(btnAddAuthor);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddUserPage userPage = new AddUserPage();
				userPage.setVisible(true);
			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddUser.setBounds(10, 27, 126, 29);
		contentPane.add(btnAddUser);
	}
}

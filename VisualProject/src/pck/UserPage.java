package pck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int UserId=0;
	
	ArrayList<Books> books = new ArrayList<Books>();
	DatabaseCon dbCon = new DatabaseCon();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	public UserPage() {
		setTitle("User Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 123, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBooks.setBounds(258, 11, 123, 29);
		contentPane.add(lblBooks);
		
		/*JList booklist = new JList();
		booklist.setBounds(247, 46, 123, 158);
		contentPane.add(booklist);*/
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		JButton btnList = new JButton("Get List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.removeAllElements();
					books = dbCon.getBooks();
					books.forEach( b -> {
						model.addElement(b.getBookId()+" "+b.getAuthorId()+" "+b.getTitle()+" "+b.getStatus());
					});
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnList.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnList.setBounds(143, 95, 104, 29);
		contentPane.add(btnList);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(257, 53, 124, 151);
		contentPane.add(scrollPane);
		JList bookList = new JList(model);
		scrollPane.setViewportView(bookList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 53, 123, 151);
		contentPane.add(scrollPane_1);
		
		DefaultListModel<String> mymodel = new DefaultListModel<String>();
		
		JList mylist = new JList(mymodel);
		scrollPane_1.setViewportView(mylist);
		
		JButton btnMyList = new JButton("My List");
		btnMyList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserId=LoginUserInfo.getInstance().getUserID();
					
					mymodel.removeAllElements();
					books = dbCon.getUserBooks(UserId);
					books.forEach( b -> {
						mymodel.addElement(b.getBookId()+" "+b.getAuthorId()+" "+b.getTitle()+" "+b.getStatus());
					});
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMyList.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMyList.setBounds(143, 55, 104, 29);
		contentPane.add(btnMyList);
		
		JButton btnGive = new JButton("Get Back");
		btnGive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGive.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGive.setBounds(143, 135, 104, 29);
		contentPane.add(btnGive);
		
		JButton btnTake = new JButton("Take");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTake.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTake.setBounds(143, 175, 104, 29);
		contentPane.add(btnTake);
	}
}

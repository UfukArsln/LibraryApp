package pck;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitle;
	
	
	ArrayList<Books> books = new ArrayList<Books>();
	ArrayList<Author> authors = new ArrayList<Author>();
	JComboBox<String> getAuthorName = new JComboBox<>();
	DatabaseCon dbCon = new DatabaseCon();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookPage frame = new AddBookPage();
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
	public AddBookPage() {
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 212, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 11, 65, 23);
		contentPane.add(lblAuthor);
		
		JComboBox cbAuthor = new JComboBox();
		cbAuthor.setBounds(84, 12, 91, 20);
		contentPane.add(cbAuthor);
		
		
		DatabaseCon dbCon = new DatabaseCon();
		try {
			dbCon.getAuthors().forEach(a -> {cbAuthor.addItem(a.getName()+" "+a.getSurname());
				
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(10, 45, 65, 23);
		contentPane.add(lblBookTitle);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(84, 46, 91, 20);
		contentPane.add(txtTitle);
		
		JLabel lblBookStatus = new JLabel("Book Status");
		lblBookStatus.setBounds(10, 79, 65, 23);
		contentPane.add(lblBookStatus);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.addItem("active");
		cbStatus.addItem("passive");
		cbStatus.setBounds(84, 80, 91, 20);
		contentPane.add(cbStatus);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Books book = new Books();
				book.setAuthorId(cbAuthor.getSelectedIndex()+1);
				book.setTitle(txtTitle.getText());
				book.setStatus(cbStatus.getSelectedItem().toString());
				
				try {
					dbCon.saveBook(book);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(84, 125, 91, 23);
		contentPane.add(btnSave);
		
		
	}

}

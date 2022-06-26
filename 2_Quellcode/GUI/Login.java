import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * 
 * public class Login generates a JFrame (GUI) for our Login interface for our
 * ToDoList.
 * 
 * @author MaxKienzle
 *
 */

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEMail;
	private JLabel lblretry;
	private JLabel lblEMail;
	private JLabel lblMatrikelnummer;
	private JButton btnretry;
	private Button btnLogin;
	private JTextField txtPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * public addEmail() { super(); Login();
		 * 
		 * } public addNachname() { super(); Login(); }
		 * 
		 * public addUser() { super(); Login(); }
		 * 
		 * public addNummer() { super(); Login(); }
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame (Login).
	 */
	public Login() {

		/**
		 * Creates and initializes a new Pane (ContentPane), where all the other
		 * applications are added to The settings like Backgroundcolor, Close-Operation,
		 * Bounds are initialized.
		 * 
		 * @author MaxKienzle
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 180, 593, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * 
		 * the left darker part of the panel is set. with all the parameters like color,
		 * Bounds and where it is added to.
		 * 
		 * @author MaxKienzle
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 182, 491);
		contentPane.add(panel);
		panel.setLayout(null);

		/**
		 * 
		 * The lettering "Login" is generated as a JLabel application.
		 * 
		 * @author MaxKienzle
		 */

		// "Login"-Lettering
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(55, 166, 71, 67); // where it is located and which Bounds it has
		lblNewLabel.setForeground(Color.WHITE); // Color of the text
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18)); // font, font size is set
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // where it is aligned inside the Label
		panel.add(lblNewLabel); // added to the panel

		/**
		 * 
		 * The "Lock"- Sign is generated as a JLabel application.
		 * 
		 * @author MaxKienzle
		 */

		// "Lock"-Sign
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/lock_29411.png"))); // Icon is added into
																									// the JLabel
		lblNewLabel_1.setBounds(10, 62, 162, 148);
		panel.add(lblNewLabel_1);

		// The rest of the JFrame is added to the contentPane, like E-Mail label,
		// different TextFields etc.
		// from here

		// "E-Mail"-Lettering
		lblEMail = new JLabel("E-Mail");
		lblEMail.setBounds(217, 67, 46, 14);
		contentPane.add(lblEMail);

		// "E-Mail"-TextField
		tfEMail = new JTextField();
		tfEMail.setBounds(217, 92, 280, 31);
		contentPane.add(tfEMail);
		tfEMail.setColumns(10);

		// "Matrikelnummer"-Lettering
		lblMatrikelnummer = new JLabel("Matrikelnummer");
		lblMatrikelnummer.setBounds(217, 162, 268, 20);
		contentPane.add(lblMatrikelnummer);

		/**
		 * Initialize and generates a Login-Button with his ActionListener, which is
		 * used for different commands.
		 * 
		 * If you click on the Login-Button the Code will check what is written in to
		 * the tfEmail-TextFiel and what is written in to the txtPasswordField. After
		 * that it compares, if it is equal to the E-Mail from the Database with his
		 * related matriculation number. If that is all right, the DashboardWindow will
		 * open, if not, an Error is issued.
		 * 
		 * @author MaxKienzle
		 * 
		 */

		// "Login"-Button
		btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = tfEMail.getText();
				String password = txtPasswordField.getText();

				try {
					/**
					 * queries the database for the entered user credentials and proceeds with the
					 * login procedure if a user is return
					 * 
					 * @author nicom, davidjl21
					 */
					DatabaseWrapper db = new DatabaseWrapper();
					db.generateConnection();
					ResultSet rsUser = db.searchUser(user, password);

					String dbEMail = "";
					String dbMatrikelnr = "";

					if (rsUser.next()) {
						dbEMail = rsUser.getString("EMail");
						dbMatrikelnr = Integer.toString(rsUser.getInt("Matrikelnr"));

					} else {
						System.out.println("Kein Nutzer gefunden");
					}
					if (user.equals(dbEMail) && password.equals(dbMatrikelnr)) { // controls the E-Mail and Number
						Login.this.dispose();
						Dashboard frame = new Dashboard();
						frame.setUndecorated(true);
						frame.setVisible(true);
					} // opens Dashboard without the Frame

					else
						lblretry.setText("Login fehlgeschlagen, bitte erneut versuchen!!!"); // Error is issued


					txtPasswordField.setVisible(false);
					tfEMail.setVisible(false);
					lblMatrikelnummer.setVisible(false);
					lblEMail.setVisible(false);
					btnLogin.setVisible(false);
					btnretry.setVisible(true);
				}

				catch (SQLException a) {
					System.out.println(a.toString());
					return;
				}

			}
		});
		btnLogin.setBackground(new Color(128, 0, 128));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(275, 320, 166, 31);
		contentPane.add(btnLogin);

		/**
		 * //Window closed on X-Button is initialized
		 * 
		 * @author MaxKienzle
		 */

		// "X"-Button
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // System will be left if you click on "X"
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(540, 5, 46, 14);
		contentPane.add(lblNewLabel_2);

		/**
		 * The "Retry"-Button is generated with his ActionListener, it will pop up with
		 * the Error message. If it is clicked, the Login-Screen will pop up again.
		 * 
		 * @author MaxKienzle
		 */

		// "Retry"-Button
		lblretry = new JLabel("");
		lblretry.setBounds(227, 134, 280, 31);
		contentPane.add(lblretry);

		btnretry = new JButton("retry");
		btnretry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();

				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnretry.setBounds(309, 264, 89, 23);
		contentPane.add(btnretry);

		// PasswordField for the matriculation number
		txtPasswordField = new JTextField();
		txtPasswordField.setBounds(217, 197, 280, 31);
		contentPane.add(txtPasswordField);
		txtPasswordField.setColumns(10);
		btnretry.setVisible(false);

		// to here

	}
}

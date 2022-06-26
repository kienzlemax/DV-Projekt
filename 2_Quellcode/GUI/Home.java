import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * public class Home generates a JFrame (GUI) for the registration for our
 * ToDoList. Therefor the firstname, lastname, EMail and Matrikelnummer (as
 * password) will be handed over to the database.
 * 
 * @author MaxKienzle
 *
 */
public class Home extends JFrame {

	private JPanel contentPane;

	private JTextField tfVorname;
	private JTextField tfNachname;
	private JTextField tfEMail;
	private JTextField passwordField;

	private Home Home;

	private JLabel lblresign;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblEMail;
	private JLabel lblMatrikelnummer;
	private JLabel lblresign2;
	private JLabel lbl_or;

	private Button btnresign;
	private Button btnSignUp;
	private Button btnLogin;

	/**
	 * Creates the parameter xx/yy ; x/y which are used to drag the JFrame to
	 * another place on the screen.
	 * 
	 * @param xx , yy / xx = start position on screen x-parameter / yy = start
	 *           position on screen y-parameter.
	 * 
	 * @param x  , y / x = final position on screen x-parameter / y = final position
	 *           on screen y-parameter
	 * 
	 * @author MaxKienzle
	 */

	int xx, yy;

	int x, y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame (Home) .
	 */
	public Home() {

		/**
		 * Creates and initializes a new Pane (ContentPane), where all the other
		 * applications are added to The settings like Backgroundcolor, Close-Operation,
		 * Bounds are initialized.
		 * 
		 * @author MaxKienzle
		 */

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 180, 686, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Initializes a new JPanel

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 275, 480);
		contentPane.add(panel);
		panel.setLayout(null);

		/**
		 * Creates a JLabel on the panel we added before with the text "Welcome" on it.
		 * Color, Font, Bounds an alignment of the text.
		 * 
		 * @author MaxKienzle
		 */
		JLabel lblWelcome = new JLabel("Welcome...");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(87, 319, 129, 49);
		panel.add(lblWelcome);

		/**
		 * Initialize a MouseListener, which is used for different commands.
		 * 
		 * If you click on the Image on the HomeFrame and hold it, the MouseListener
		 * gets the position of parameter xx/yy, Which be used to calculate the new
		 * Location of the Frame when it is dragged.
		 * 
		 * @author MaxKienzle
		 * 
		 */

		JLabel lblImage = new JLabel("Image"); // Where the MouseListener is used on
		lblImage.addMouseListener(new MouseAdapter() { // adds the MouseListener
			@Override
			public void mousePressed(MouseEvent e) { // Command of the MouseListener (mousePressed)
				xx = e.getX(); // get the positions of x-parameter
				yy = e.getY(); // get the position of y-parameter
			}
		});

		/**
		 * Initialize another MouseListener, which interacts with the MouseListener
		 * before.
		 * 
		 * When the mouse is pressed it gets the X/Y-Parameters and by dragging the
		 * Frame to a new position, this mouse Listener gets the new x/y-parameter and
		 * calculate the distance between the start and the destination and sets the
		 * frame to the the new location.
		 * 
		 * @author MaxKienzle
		 */
		lblImage.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				x = arg0.getXOnScreen(); // get the x-parameter from the Frame on screen while dragging
				y = arg0.getYOnScreen(); // get the y-parameter from the Frame on screen while dragging
				Home.this.setLocation(x - xx, y - yy); // calculates the current position of the Frame.
			}
		});

		// adds the label (lblImage) to the "panel" and creates the Bounds
		lblImage.setBounds(-33, 0, 318, 251);
		panel.add(lblImage);
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setIcon(new ImageIcon(Home.class.getResource("/images/istockphoto-877267194-170667a (2).jpg"))); // set
																													// the
																													// chosen
		// Icon into the lblImage and generates the path to the folder.

		/**
		 * Creates the ActionListener for the Button (btnSignUp). Click on the Button
		 * and it generates you the different Strings
		 * (firstname/lastname/password/user), in which the text from the different
		 * fields are saved. They can be used later to compare if the entered text is
		 * right.
		 * 
		 * @author MaxKienzle
		 */

		// "SignUp"-Button
		btnSignUp = new Button("SignUp");

		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = tfVorname.getText(); // saves the text from tfVorname into the String firstname
				String lastname = tfNachname.getText(); // saves the text from tfNachname into the String lastname
				String password = passwordField.getText(); // saves the text from passwordField into the String password
				String email = tfEMail.getText(); // saves the text from tfEMail into the String user
				
				
				/**
				 * Following code section is used to control if the text from the password are
				 * only numbers (Matrikelnummer = password = Numbers) and if the EMail (User =
				 * EMail) contains the sign "@".
				 * 
				 * if that is true the HomeFrame disposes and the LoginFrame will be opened.
				 * 
				 * @author MaxKienzle
				 */
				if (password.matches("[+-]?\\d*(\\.\\d+)?") && email.contains("@") && firstname.length() > 0 && lastname.length() > 0) {
					DatabaseWrapper db = new DatabaseWrapper();
					db.generateConnection();
					db.addUser(firstname, lastname, password, email);
					Home.this.dispose();
					Login Login = new Login();
					Login.setUndecorated(true);
					Login.setVisible(true);

				}

				/**
				 * if it is wrong, it closes all the TextFields and shows up the following
				 * information. and adds a new Button where you can try to resign.
				 * 
				 * @author MaxKienzle
				 */

				else
					lblresign.setText("Matrikelnummer muss aus Zahlen bestehen"); // Info is added to the label
				lblresign2.setText("und EMail muss mindestens @ enthalten !"); // Info is added to the label
				passwordField.setVisible(false);
				tfEMail.setVisible(false);
				tfVorname.setVisible(false);
				tfNachname.setVisible(false);
				passwordField.setVisible(false); // rest is set unvisible
				lblEMail.setVisible(false);
				lblVorname.setVisible(false);
				lblNachname.setVisible(false);
				lblMatrikelnummer.setVisible(false);
				lbl_or.setVisible(false);
				btnSignUp.setVisible(false);
				btnLogin.setVisible(false);
				btnresign.setVisible(true); // Button to resign is set visible

			}
		});
		// all the other applications like Buttons/TextFields etc. are initialized
		// from here

		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(128, 0, 128));
		btnSignUp.setBounds(352, 302, 166, 31);
		contentPane.add(btnSignUp);

		// "Vorname"-TextField
		tfVorname = new JTextField();
		tfVorname.setBounds(285, 40, 280, 31);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);

		// "Vorname"-Lettering
		lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVorname.setBounds(285, 11, 93, 31);
		contentPane.add(lblVorname);

		// "Nachname"-Lettering
		lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNachname.setBounds(285, 82, 234, 24);
		contentPane.add(lblNachname);

		// "Nachname"-TextField
		tfNachname = new JTextField();
		tfNachname.setColumns(10);
		tfNachname.setBounds(285, 109, 280, 31);
		contentPane.add(tfNachname);

		// "E-Mail"-Lettering
		lblEMail = new JLabel("E-Mail");
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEMail.setBounds(285, 151, 46, 14);
		contentPane.add(lblEMail);

		// "E-Mail"-TextField
		tfEMail = new JTextField();
		tfEMail.setColumns(10);
		tfEMail.setBounds(285, 176, 280, 31);
		contentPane.add(tfEMail);

		// "Matrikelnummer"-Lettering
		lblMatrikelnummer = new JLabel("Matrikelnummer");
		lblMatrikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatrikelnummer.setBounds(285, 218, 185, 14);
		contentPane.add(lblMatrikelnummer);

		// "Matrikelnummer"-Passwordfield
		passwordField = new JTextField();
		passwordField.setBounds(285, 243, 280, 31);
		contentPane.add(passwordField);

		// to here

		/**
		 * adds an MouseListener to the label_close, when u click on it, the JOptionPane
		 * opens and ask if you are sure to leave. if you click "yes" the application
		 * will be closed.
		 *
		 * @author MaxKienzle
		 */

		// "X"-Button
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (JOptionPane.showConfirmDialog(Home, "Sind Sie sich sicher ?") == 0)
					System.exit(0);
			}
		});

		// Label for "X"-Button
		lbl_close.setForeground(Color.RED);
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_close.setBounds(640, 5, 46, 14);
		contentPane.add(lbl_close);

		// "or"-Lettering
		lbl_or = new JLabel("or");
		lbl_or.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_or.setBounds(411, 339, 46, 14);
		contentPane.add(lbl_or);

		/**
		 * Initialize the Button (btnLogin) with its Action Listener. When it is clicked
		 * the HomeFrame will be closed and you will be forwarded to the LoginScreen.
		 * 
		 * @author MaxKienzle
		 */

		// "Login"-Button
		btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.this.dispose();

				Login Login = new Login();
				Login.setUndecorated(true);
				Login.setVisible(true);

			}
		});
		btnLogin.setBounds(400, 359, 70, 22);
		contentPane.add(btnLogin);

		// "Resign"-Label for Text
		lblresign = new JLabel("");
		lblresign.setHorizontalAlignment(SwingConstants.CENTER);
		lblresign.setBounds(285, 151, 385, 24);
		contentPane.add(lblresign);

		lblresign2 = new JLabel("");
		lblresign2.setHorizontalAlignment(SwingConstants.CENTER);
		lblresign2.setBounds(285, 176, 385, 31);
		contentPane.add(lblresign2);

		/**
		 * Initializes the Button (btnresign) with its ActionListener if it is clicked
		 * the HomeFrame is current HomeFrame is closed and a new one to SignUp opens.
		 * 
		 * @author MaxKienzle
		 */

		// "Resign"-Button
		btnresign = new Button("Resign");
		btnresign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.this.dispose();

				Home Home = new Home();
				Home.setUndecorated(true);
				Home.setVisible(true);

			}
		});
		btnresign.setBounds(400, 280, 70, 22);
		contentPane.add(btnresign);
		btnresign.setVisible(false);

	}
}

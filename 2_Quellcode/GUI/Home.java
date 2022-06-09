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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField tfVorname;
	private JTextField tfNachname;
	private JTextField tfEMail;
	private JPasswordField passwordField;
	private JLabel lblresign;
    private Home Home;
    private JLabel lblVorname;
    private JLabel lblNachname;
    private JLabel lblEMail;
    private JLabel lblMatrikelnummer;
    private Button btnresign;
    private JLabel lblor;
    private Button btnSignUp;
    private Button btnLogin;
    private JLabel lblresign2;
    
	
	int xx,xy;
	

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
	 * Create the frame.
	 */
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 275, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome...");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(87, 319, 129, 49);
		panel.add(lblWelcome);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		lblImage.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
		        int y = arg0.getYOnScreen();
		       Home.this.setLocation(x - xx, y - xy);  
			}
		});
		lblImage.setBounds(-33, 0, 318, 251);
		panel.add(lblImage);
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setIcon(new ImageIcon(Home.class.getResource("/images/istockphoto-877267194-170667a (2).jpg")));
		
		btnSignUp = new Button("SignUp");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String firstname = tfVorname.getText();
				String lastname = tfNachname.getText();
				String password = passwordField.getText();
				String user = tfEMail.getText();
				
				
				if( password.matches("[+-]?\\d*(\\.\\d+)?") && user.contains("@")) {
					Home.this.dispose();
					Login Login = new Login();
					Login.setUndecorated(true);
					Login.setVisible(true);	
					
				}
				else lblresign.setText("Matrikelnummer muss aus Zahlen bestehen" );
				lblresign2.setText("und EMail muss mindestens @ enthalten !");
				passwordField.setVisible(false);
				tfEMail.setVisible(false);
				tfVorname.setVisible(false);
				tfNachname.setVisible(false);
				passwordField.setVisible(false);
				lblEMail.setVisible(false);
				lblVorname.setVisible(false);
				lblNachname.setVisible(false);
				lblMatrikelnummer.setVisible(false);
				lblor.setVisible(false);
				btnSignUp.setVisible(false);
				btnLogin.setVisible(false);
				btnresign.setVisible(true);
				
				
				}
				
				
			
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(128, 0, 128));
		btnSignUp.setBounds(352, 302, 166, 31);
		contentPane.add(btnSignUp);
		
		tfVorname = new JTextField();
		tfVorname.setBounds(285, 40, 280, 31);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);
		
		lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVorname.setBounds(285, 11, 93, 31);
		contentPane.add(lblVorname);
		
		lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNachname.setBounds(285, 82, 234, 24);
		contentPane.add(lblNachname);
		
		tfNachname = new JTextField();
		tfNachname.setColumns(10);
		tfNachname.setBounds(285, 109, 280, 31);
		contentPane.add(tfNachname);
		
		lblEMail = new JLabel("E-Mail");
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEMail.setBounds(285, 151, 46, 14);
		contentPane.add(lblEMail);
		
		tfEMail = new JTextField();
		tfEMail.setColumns(10);
		tfEMail.setBounds(285, 176, 280, 31);
		contentPane.add(tfEMail);
		
		lblMatrikelnummer = new JLabel("Matrikelnummer");
		lblMatrikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatrikelnummer.setBounds(285, 218, 185, 14);
		contentPane.add(lblMatrikelnummer);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 243, 280, 31);
		contentPane.add(passwordField);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(Home, "Sind Sie sich sicher ?") ==0 )
				System.exit(0);
			}
		});
		lbl_close.setForeground(Color.RED);
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_close.setBounds(640, 5, 46, 14);
		contentPane.add(lbl_close);
		
		lblor = new JLabel("or");
		lblor.setHorizontalAlignment(SwingConstants.CENTER);
		lblor.setBounds(411, 339, 46, 14);
		contentPane.add(lblor);
		
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
		
		lblresign = new JLabel("");
		lblresign.setHorizontalAlignment(SwingConstants.CENTER);
		lblresign.setBounds(285, 151, 385, 24);
		contentPane.add(lblresign);
		
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
		
		lblresign2 = new JLabel("");
		lblresign2.setHorizontalAlignment(SwingConstants.CENTER);
		lblresign2.setBounds(285, 176, 385, 31);
		contentPane.add(lblresign2);
		
		
	}
}

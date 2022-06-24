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

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

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
		public addEmail() {
			super();
			Login();
		
		}
		public addNachname() {
			super();
			Login();
		}
		
		public addUser() {
			super();
			Login();
		}
		
		public addNummer() {
			super();
			Login();
		}
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
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 180, 593, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 182, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(55, 166, 71, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/lock_29411.png")));
		lblNewLabel_1.setBounds(10, 62, 162, 148);
		panel.add(lblNewLabel_1);
		
		lblEMail = new JLabel("E-Mail");
		lblEMail.setBounds(217, 67, 46, 14);
		contentPane.add(lblEMail);
		
		tfEMail = new JTextField();
		tfEMail.setBounds(217, 92, 280, 31);
		contentPane.add(tfEMail);
		tfEMail.setColumns(10);
		
		lblMatrikelnummer = new JLabel("Matrikelnummer");
		lblMatrikelnummer.setBounds(217, 162, 268, 20);
		contentPane.add(lblMatrikelnummer);
		
		btnLogin = new Button("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = tfEMail.getText();
				String password = txtPasswordField.getText();
				
	
				
				if(user.equals("kienzle-maximilian@t-online.de") && password.equals("266371")) {
				Login.this.dispose();
				Dashboard frame = new Dashboard();
				frame.setUndecorated(true);
				frame.setVisible(true);}
				
				else lblretry.setText("Login fehlgeschlagen, bitte erneut versuchen!!!");
				txtPasswordField.setVisible(false);
				tfEMail.setVisible(false);
				lblMatrikelnummer.setVisible(false);
				lblEMail.setVisible(false);
				btnLogin.setVisible(false);
				btnretry.setVisible(true);
				
				 	
			}
		});
		btnLogin.setBackground(new Color(128, 0, 128));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(275, 320, 166, 31);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(540, 5, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblretry = new JLabel("");
		lblretry.setBounds(227, 134, 280, 31);
		contentPane.add(lblretry);
		
		btnretry = new JButton("retry");
		btnretry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();

				Login frame =new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnretry.setBounds(309, 264, 89, 23);
		contentPane.add(btnretry);
		
		txtPasswordField = new JTextField();
		txtPasswordField.setBounds(217, 197, 280, 31);
		contentPane.add(txtPasswordField);
		txtPasswordField.setColumns(10);
		btnretry.setVisible(false);
		
		
	
	}
}

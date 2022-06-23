

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * public class Dashboard generates a JFrame (GUI) for MainMenu for our ToDoList.
 * 
 * @author MaxKienzle
 *
 */
public class Dashboard extends JFrame {

	private JPanel contentPane;
	private Dashboard Dashboard;
	private JPanel panel1;
	private JPanel panel2;
	
	/**
	 * Creates the parameter xx/yy ; x/y which are used to drag the JFrame to another place on the screen.
	 * 
	 * @param xx , yy /   xx = start position on screen x-parameter / yy = start position on screen y-parameter.
	 * 
	 * @param x , y / x = final position on screen x-parameter / y = final position on screen y-parameter
	 * 
	 * @author MaxKienzle
	 */
	
	
	int xx,xy;
	
	int x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame (Dashboard).
	 */
	public Dashboard() {
		
		
		/** Creates and initializes a new Pane (ContentPane), where all the other applications are added to
		 * The settings like Backgroundcolor, Close-Operation, Bounds are initialized.
		 * 
		 * @author MaxKienzle
		 */
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 607, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		/**
		 * Initialize another MouseListener, which interacts with the MouseListener after that.
		 * 
		 * When the mouse is pressed it gets the X/Y-Parameters and by dragging the Frame to a new position, this mouse Listener 
		 * gets the new x/y-parameter and calculate the distance between the start and the destination and sets the frame to the 
		 * the new location.
		 * 
		 * @author MaxKienzle
		 */
		JPanel panel = new JPanel(); //Where the MouseListener is used on
		panel.addMouseMotionListener(new MouseMotionAdapter() { // adds the MouseListener 
			@Override
			public void mouseDragged(MouseEvent arg0) { //Command of the MouseListener (mouseDragged)
				x = arg0.getXOnScreen(); // get the x-parameter from the Frame on screen while dragging
		        y = arg0.getYOnScreen(); // get the y-parameter from the Frame on screen while dragging
		       Dashboard.this.setLocation(x - xx, y - xy); //calculates the current position of the Frame.
			}
		});
		

		/**
		 * Initialize a MouseListener, which is used for different commands.
		 * 
		 * If you click on the Image on the HomeFrame and hold it, the MouseListener gets the position of parameter xx/yy,
		 * Which be used to calculate the new Location of the Frame when it is dragged.
		 * 
		 * @author MaxKienzle
		 * 
		 */
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { //Command of the MouseListener (mousePressed)
				xx = e.getX();  // get the positions of x-parameter
		        xy = e.getY();  // get the position of y-parameter
			}
		});
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 100, 456);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("");
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel1.setVisible(true);
				panel2.setVisible(true);
			}
		});
		lblMenu.setBackground(Color.LIGHT_GRAY);
		lblMenu.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-benutzer-men\u00FC-m\u00E4nnlich-32 (2).png")));
		lblMenu.setBounds(32, 25, 32, 42);
		panel.add(lblMenu);
		
		
		//all the other applications like Buttons/TextFields etc. are initialized
		//from here
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(128, 0, 128));
		panel1.setBounds(0, 90, 100, 184);
		panel.add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 32, 85, 3);
		panel1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 64, 85, 3);
		panel1.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(7, 96, 85, 3);
		panel1.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(7, 128, 85, 3);
		panel1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(7, 160, 85, 3);
		panel1.add(separator_4);
		
		// to here
		
		JLabel lblNewList = new JLabel("");
		lblNewList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewList frame =new NewList();
				frame.setUndecorated(true);
				frame.setVisible(true);			
			}
		});
		lblNewList.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-liste-hinzuf\u00FCgen-20.png")));
		lblNewList.setBounds(20, 7, 20, 20);
		panel1.add(lblNewList);
		
		JLabel lblNewGroupList = new JLabel("");
		lblNewGroupList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewGroup frame = new NewGroup();
				frame.setUndecorated(true);
				frame.setVisible(true);			
			}
		});
		lblNewGroupList.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-f\u00FCgen-sie-benutzer-zur-gruppe-hinzu-mann-mann-20.png")));
		lblNewGroupList.setBounds(20, 39, 20, 20);
		panel1.add(lblNewGroupList);
		
		JLabel lblList = new JLabel("");
		lblList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
		});
		lblList.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-aufgabenliste-20.png")));
		lblList.setBounds(20, 103, 20, 20);
		panel1.add(lblList);
		
		JLabel lblCalendary = new JLabel("");
		lblCalendary.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-kalender-20.png")));
		lblCalendary.setBounds(20, 135, 20, 20);
		panel1.add(lblCalendary);
		
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0, 330, 100, 30);
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		JLabel lblBin = new JLabel("");
		lblBin.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/icons8-m\u00FCll-l\u00F6schen-20.png")));
		lblBin.setBounds(37, 5, 20, 20);
		panel2.add(lblBin);
		
		Button btnLogout = new Button("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(Dashboard, "Sind Sie sich sicher ?") ==0 ) {
					Dashboard.this.dispose();
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
					
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(new Color(128, 0, 128));
		btnLogout.setBounds(15, 406, 70, 22);
		panel.add(btnLogout);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(Color.RED);
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX.setBounds(545, 0, 46, 14);
		contentPane.add(lblX);
	}
}

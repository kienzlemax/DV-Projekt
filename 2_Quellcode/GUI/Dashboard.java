

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

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private Dashboard Dashboard;
	private JPanel panel1;
	private JPanel panel2;
	
	
	
	
	int xx,xy;

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
	 * Create the frame.
	 */
	public Dashboard() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 607, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
		        int y = arg0.getYOnScreen();
		       Dashboard.this.setLocation(x - xx, y - xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
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

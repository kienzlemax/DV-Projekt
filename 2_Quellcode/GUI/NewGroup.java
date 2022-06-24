import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Button;


/**
 * 
 * public class NewList generates a JFrame (GUI) to add a NewGroup.
 * 
 * @author MaxKienzle
 *
 */
public class NewGroup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGroup frame = new NewGroup();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame (NewGroup).
	 */
	public NewGroup() {
		
		/** 
		 * Creates and initializes a new Pane (ContentPane), where all the other applications are added to
		 * The settings like Backgroundcolor, Close-Operation, Bounds are initialized.
		 * 
		 * @author MaxKienzle
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 220, 437, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Panel for Icon and TextField
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 61, 434, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Lettering Name
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		//TextField for the name of the List
		textField = new JTextField();
		textField.setBounds(10, 36, 402, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		//"Logo"-Lettering
		JLabel lblNewLabel_2 = new JLabel("Logo");
		lblNewLabel_2.setBounds(10, 85, 46, 14);
		panel.add(lblNewLabel_2);
		
		/**
		 * MouseListeners added,to choose a color for the NewList (optional).
		 */
		
		//from here (no function), only added the Icons
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(NewGroup.class.getResource("/icons/icons8-nutzergruppe-2-32 (1).png")));
		lblNewLabel_3.setBounds(50, 122, 32, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setIcon(new ImageIcon(NewGroup.class.getResource("/icons/icons8-nutzergruppe-2-32 (2).png")));
		lblNewLabel_3_1.setBounds(120, 122, 32, 32);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setIcon(new ImageIcon(NewGroup.class.getResource("/icons/icons8-nutzergruppe-2-32 (3).png")));
		lblNewLabel_3_2.setBounds(190, 122, 32, 32);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("New label");
		lblNewLabel_3_3.setIcon(new ImageIcon(NewGroup.class.getResource("/icons/icons8-nutzergruppe-2-32 (4).png")));
		lblNewLabel_3_3.setBounds(260, 122, 32, 32);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		lblNewLabel_3_4.setIcon(new ImageIcon(NewGroup.class.getResource("/icons/icons8-nutzergruppe-2-32.png")));
		lblNewLabel_3_4.setBounds(330, 122, 32, 32);
		panel.add(lblNewLabel_3_4);
		
		//to here
		
		//JSeparators are the small lines between the Icons in the GUI, which are separating the Icons vertical.
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(103, 115, 5, 50);
		panel.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setForeground(Color.WHITE);
		separator_1_1.setBackground(Color.WHITE);
		separator_1_1.setBounds(173, 115, 5, 50);
		panel.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setForeground(Color.WHITE);
		separator_1_2.setBackground(Color.WHITE);
		separator_1_2.setBounds(243, 115, 5, 50);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_3.setForeground(Color.WHITE);
		separator_1_3.setBackground(Color.WHITE);
		separator_1_3.setBounds(313, 115, 5, 50);
		panel.add(separator_1_3);
		
		//"Create"-Button and ActionListener (without function)
		Button button = new Button("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBackground(new Color(128, 0, 128));
		button.setBounds(178, 195, 70, 22);
		panel.add(button);
		
		//Dark Panel for the lettering "New Group"
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 452, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//"New List"-Lettering
		JLabel lblNewLabel = new JLabel("NEW GROUP");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(145, 15, 156, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		
		//"X"-Button
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewGroup.this.dispose();
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(383, 0, 46, 14);
		panel_1.add(lblNewLabel_4);
	}
}

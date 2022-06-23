import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewList extends JFrame {

	private JPanel contentPane;
	public static JTextField tfName;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewList frame = new NewList();
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
	public NewList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 439, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 61, 434, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(103, 115, 5, 50);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 24, 46, 14);
		panel.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(10, 49, 414, 20);
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Logo");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(NewList.class.getResource("/icons/icons8-aufgabenliste-32 (1).png")));
		lblNewLabel_3.setBounds(50, 122, 32, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(NewList.class.getResource("/icons/icons8-aufgabenliste-32 (2).png")));
		lblNewLabel_4.setBounds(120, 122, 32, 32);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(NewList.class.getResource("/icons/icons8-aufgabenliste-32 (3).png")));
		lblNewLabel_5.setBounds(190, 122, 32, 32);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(NewList.class.getResource("/icons/icons8-aufgabenliste-32 (4).png")));
		lblNewLabel_6.setBounds(260, 122, 32, 32);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(NewList.class.getResource("/icons/icons8-aufgabenliste-32.png")));
		lblNewLabel_7.setBounds(330, 122, 32, 32);
		panel.add(lblNewLabel_7);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(173, 115, 5, 50);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(243, 115, 5, 50);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(313, 115, 5, 50);
		panel.add(separator_3);
		
		Button button = new Button("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inputText = tfName.getText();
				
				Todoliste list = new Todoliste();
				list.lblName.setText(inputText);
				list.setUndecorated(true);
				list.setVisible(true);
				
				
				NewList newList = new NewList();
				newList.dispose();
				
				
				
				
			}
		});
		button.setBackground(new Color(128, 0, 128));
		button.setBounds(178, 195, 70, 22);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 452, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW LIST");
		lblNewLabel.setBounds(172, 17, 90, 22);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("X");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewList.this.dispose();
			}
		});
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(383, 5, 46, 14);
		panel_1.add(lblNewLabel_8);
	}
}

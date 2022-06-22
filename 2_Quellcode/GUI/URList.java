import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class URList extends JFrame {

	private JPanel contentPane;
	JLabel lblList1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					URList frame = new URList();
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
	public URList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputText = lblName.getText();
				
				
				Todoliste frame = new Todoliste();
				frame.lblName.setText(inputText);
				frame.setVisible(true);
			}
		});
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 255, 44);
		contentPane.add(panel);
		
		lblList1 = new JLabel("");
		lblList1.setHorizontalAlignment(SwingConstants.LEFT);
		lblList1.setForeground(Color.WHITE);
		panel.add(lblList1);
	}

}

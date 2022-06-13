import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checklist extends JFrame {

	private JPanel contentPane;
	public JTextField tfName;
	private JLabel lblList;
	//private boolean checked;
	private JButton btnaddtask;
	//private JButton btnclearlist;
	private Panel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checklist frame = new Checklist();
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
	public Checklist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 458, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		String Name = tfName.getText();
		
		lblList = new JLabel(Name+" ");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.WHITE);
		lblList.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblList.setBounds(36, 11, 383, 37);
		panel.add(lblList);
		
		//checked = false;
		
		Button btnaddtask = new Button("Add Task");
		btnaddtask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		
		btnaddtask.setForeground(Color.WHITE);
		btnaddtask.setBackground(new Color(128, 0, 128));
		btnaddtask.setBounds(107, 229, 70, 22);
		contentPane.add(btnaddtask);
		
		Button btnclearlist = new Button("Clear List");
		btnclearlist.setForeground(Color.WHITE);
		btnclearlist.setBackground(new Color(128, 0, 128));
		btnclearlist.setBounds(260, 229, 70, 22);
		contentPane.add(btnclearlist);
		
		panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 65, 434, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		
		Checkbox task1 = new Checkbox("");
		task1.setBounds(10, 5, 95, 22);
		panel_1.add(task1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(0, 101, 434, 30);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		
		Checkbox task2 = new Checkbox("");
		task2.setBounds(10, 5, 95, 22);
		panel_1_1.add(task2);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2.setBounds(0, 137, 434, 30);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		
		Checkbox task3 = new Checkbox("");
		task3.setBounds(10, 5, 95, 22);
		panel_1_2.add(task3);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(Color.LIGHT_GRAY);
		panel_1_3.setBounds(0, 173, 434, 30);
		contentPane.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		
		Checkbox task4 = new Checkbox("");
		task4.setBounds(10, 5, 95, 22);
		panel_1_3.add(task4);
		
		
	}
}

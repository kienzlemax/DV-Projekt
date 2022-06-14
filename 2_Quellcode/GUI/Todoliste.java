import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.SystemColor;

public class Todoliste extends JFrame {

	private JPanel ctnAufgabe1;
	private JTextField textField;
	private JButton done;
	
	private boolean checked;
	private JLabel lblAufgabe1;
	private JLabel lblAufgabe2;
	private JLabel lblAufgabe3;
	private JLabel lblAufgabe5;
	private JLabel lblAufgabe6;
	private JLabel lblAufgabe7;
	private JTextField txtEingabe;
	private JLabel lblAufgabe4;
	private JButton btnAddTask_2;
	private JButton btnAddTask_3;
	private JButton btnAddTask_4;
	private JButton btnAddTask_5;
	private JButton btnAddTask_6;
	private JButton btnAddTask_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Todoliste frame = new Todoliste();
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
	public Todoliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ctnAufgabe1 = new JPanel();
		ctnAufgabe1.setBackground(Color.GREEN);
		ctnAufgabe1.setForeground(Color.GREEN);
		ctnAufgabe1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctnAufgabe1);
		ctnAufgabe1.setLayout(null);
		
		JButton btnClearList = new JButton("Clear List");
		btnClearList.setBounds(304, 39, 122, 20);
		ctnAufgabe1.add(btnClearList);
		btnClearList.addActionListener(new UnserListener8());
		
		JButton btnAddTask_1 = new JButton("Add Task 1");
		btnAddTask_1.setBounds(319, 98, 107, 13);
		ctnAufgabe1.add(btnAddTask_1);
		getContentPane().add(btnAddTask_1);
		btnAddTask_1.addActionListener(new UnserListener1());

		
		done = new JButton("Done");
		done.setBounds(0, 0, 0, 0);
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setFocusPainted(false);
		
		getContentPane().add(done);
		
		checked = false;
		ctnAufgabe1.add(btnAddTask_1);
		
		JLabel lblNewLabel = new JLabel("Hier kommt Listen Name \u00FCber Datenbank");
		lblNewLabel.setBounds(10, 0, 426, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ctnAufgabe1.add(lblNewLabel);
		
		lblAufgabe1 = new JLabel("1.");
		lblAufgabe1.setBackground(Color.DARK_GRAY);
		lblAufgabe1.setForeground(SystemColor.desktop);
		lblAufgabe1.setBounds(10, 98, 416, 13);
		ctnAufgabe1.add(lblAufgabe1);
		
		lblAufgabe2 = new JLabel("2.");
		lblAufgabe2.setBounds(10, 121, 416, 13);
		ctnAufgabe1.add(lblAufgabe2);
		
		lblAufgabe3 = new JLabel("3.");
		lblAufgabe3.setBounds(10, 144, 416, 13);
		ctnAufgabe1.add(lblAufgabe3);
		
		lblAufgabe4 = new JLabel("4.");
		lblAufgabe4.setBounds(10, 168, 416, 13);
		ctnAufgabe1.add(lblAufgabe4);
		
		lblAufgabe5 = new JLabel("5.");
		lblAufgabe5.setBounds(10, 191, 416, 13);
		ctnAufgabe1.add(lblAufgabe5);
		
		lblAufgabe6 = new JLabel("6.");
		lblAufgabe6.setBounds(10, 214, 416, 13);
		ctnAufgabe1.add(lblAufgabe6);
		
		lblAufgabe7 = new JLabel("7.");
		lblAufgabe7.setBounds(10, 237, 416, 13);
		ctnAufgabe1.add(lblAufgabe7);
		
		txtEingabe = new JTextField("Hier kommen die Aufgaben rein");
		txtEingabe.setBounds(10, 69, 416, 19);
		ctnAufgabe1.add(txtEingabe);
		txtEingabe.setColumns(10);
		getContentPane().add(txtEingabe);
		
		btnAddTask_2 = new JButton("Add Task 2");
		btnAddTask_2.setBounds(319, 121, 107, 13);
		ctnAufgabe1.add(btnAddTask_2);
		btnAddTask_2.addActionListener(new UnserListener2());
		
		btnAddTask_3 = new JButton("Add Task 3");
		btnAddTask_3.setBounds(319, 144, 107, 13);
		ctnAufgabe1.add(btnAddTask_3);
		btnAddTask_3.addActionListener(new UnserListener3());
		
		btnAddTask_4 = new JButton("Add Task 4");
		btnAddTask_4.setBounds(319, 168, 107, 13);
		ctnAufgabe1.add(btnAddTask_4);
		btnAddTask_4.addActionListener(new UnserListener4());
		
		btnAddTask_5 = new JButton("Add Task 5");
		btnAddTask_5.setBounds(319, 191, 107, 13);
		ctnAufgabe1.add(btnAddTask_5);
		btnAddTask_5.addActionListener(new UnserListener5());
		
		btnAddTask_6 = new JButton("Add Task 6");
		btnAddTask_6.setBounds(319, 214, 107, 13);
		ctnAufgabe1.add(btnAddTask_6);
		btnAddTask_6.addActionListener(new UnserListener6());
		
		btnAddTask_7 = new JButton("Add Task 7");
		btnAddTask_7.setBounds(319, 237, 107, 13);
		ctnAufgabe1.add(btnAddTask_7);
		btnAddTask_7.addActionListener(new UnserListener7());
		
	
	}
	private class UnserListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				String a = txtEingabe.getText();
				lblAufgabe1.setText("1. "+a);
		}
	}
	private class UnserListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				String b = txtEingabe.getText();
				lblAufgabe2.setText("2. "+b);
				
		}
		
	}
	private class UnserListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				String c = txtEingabe.getText();
				lblAufgabe3.setText("3. "+c);
				
		}
		
	}
	private class UnserListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				String d = txtEingabe.getText();
				lblAufgabe4.setText("4. "+d);
				
		}
		
	}
	private class UnserListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				String y= txtEingabe.getText();
				lblAufgabe5.setText("5. "+y);
				
		}
		
	}
	private class UnserListener6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				String f = txtEingabe.getText();
				lblAufgabe6.setText("6. "+f);
				
		}
		
	}
	private class UnserListener7 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				String g = txtEingabe.getText();
				lblAufgabe7.setText("7. "+g);
				
		}
		
	}
	private class UnserListener8 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				lblAufgabe1.setText("1.");
				lblAufgabe2.setText("2.");
				lblAufgabe3.setText("3.");
				lblAufgabe4.setText("4.");
				lblAufgabe5.setText("5.");
				lblAufgabe6.setText("6.");
				lblAufgabe7.setText("7.");
		}
		
	}
}

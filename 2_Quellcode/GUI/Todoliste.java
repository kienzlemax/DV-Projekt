import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.google.api.services.calendar.Calendar;
import java.security.GeneralSecurityException;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;


public class Todoliste extends JFrame {

	public JPanel ctnAufgabe1;
	public JLabel lblName;
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
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Todoliste frame.
	 */
	public Todoliste() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(424, 200, 566, 377);

		ctnAufgabe1 = new JPanel();
		ctnAufgabe1.setBackground(Color.GRAY);
		ctnAufgabe1.setForeground(Color.GRAY);
		ctnAufgabe1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctnAufgabe1);
		ctnAufgabe1.setLayout(null);

		/**
		 * Creates Button to delete the hole List
		 */
		JButton btnClearList = new JButton("Clear List");
		btnClearList.setBounds(304, 62, 122, 20);
		ctnAufgabe1.add(btnClearList);
		btnClearList.addActionListener(new UnserListener8());

		JLabel lblNewLabel_8 = new JLabel("X");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Todoliste.this.dispose();
			}
		});
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(383, 5, 175, 14);
		ctnAufgabe1.add(lblNewLabel_8);

		//Create Label for the name of the list
		lblName = new JLabel("");
		lblName.setFont(lblName.getFont().deriveFont(lblName.getFont().getStyle() | Font.BOLD,16));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(44, 0, 350, 40);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		ctnAufgabe1.add(lblName);

		//Create Label were the task will be safed
		lblAufgabe1 = new JLabel("1.");
		lblAufgabe1.setBackground(Color.DARK_GRAY);
		lblAufgabe1.setForeground(Color.WHITE);
		lblAufgabe1.setBounds(10, 121, 312, 13);
		ctnAufgabe1.add(lblAufgabe1);


		lblAufgabe2 = new JLabel("2.");
		lblAufgabe2.setForeground(Color.WHITE);
		lblAufgabe2.setBounds(10, 144, 312, 13);
		ctnAufgabe1.add(lblAufgabe2);

		lblAufgabe3 = new JLabel("3.");
		lblAufgabe3.setForeground(Color.WHITE);
		lblAufgabe3.setBounds(10, 167, 312, 13);
		ctnAufgabe1.add(lblAufgabe3);

		lblAufgabe4 = new JLabel("4.");
		lblAufgabe4.setForeground(Color.WHITE);
		lblAufgabe4.setBounds(10, 191, 312, 13);
		ctnAufgabe1.add(lblAufgabe4);

		lblAufgabe5 = new JLabel("5.");
		lblAufgabe5.setForeground(Color.WHITE);
		lblAufgabe5.setBounds(10, 214, 312, 13);
		ctnAufgabe1.add(lblAufgabe5);

		lblAufgabe6 = new JLabel("6.");
		lblAufgabe6.setForeground(Color.WHITE);
		lblAufgabe6.setBounds(10, 237, 312, 13);
		ctnAufgabe1.add(lblAufgabe6);

		lblAufgabe7 = new JLabel("7.");
		lblAufgabe7.setForeground(Color.WHITE);
		lblAufgabe7.setBounds(10, 260, 312, 13);
		ctnAufgabe1.add(lblAufgabe7);

		//Creates Textfield were the Taks can be descripted
		txtEingabe = new JTextField("Hier kommen die Aufgaben rein 20.02.2022");
		txtEingabe.setBounds(10, 92, 416, 19);
		ctnAufgabe1.add(txtEingabe);
		txtEingabe.setColumns(10);
		getContentPane().add(txtEingabe);
		/**
		 * Creates Button to Add Task in den JLabel
		 * @author Felix
		 */
		//"Add" Button for Task 1
		JButton btnAddTask_1 = new JButton("Add"); //creates JButton
		btnAddTask_1.setFont(new Font("Tahoma", Font.PLAIN, 9)); //set font, size
		btnAddTask_1.setBounds(375, 121, 51, 13); //set were the JButton ist located
		ctnAufgabe1.add(btnAddTask_1);
		btnAddTask_1.addActionListener(new UnserListener1()); // add Actionlistener to Add Task to JLabel

		//"Add" Button for Task 2
		btnAddTask_2 = new JButton("Add");
		btnAddTask_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_2.setBounds(375, 144, 51, 13);
		ctnAufgabe1.add(btnAddTask_2);
		btnAddTask_2.addActionListener(new UnserListener2());

		//"Add" Button for Task 3
		btnAddTask_3 = new JButton("Add");
		btnAddTask_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_3.setBounds(375, 167, 51, 13);
		ctnAufgabe1.add(btnAddTask_3);
		btnAddTask_3.addActionListener(new UnserListener3());

		//"Add" Button for Task 4
		btnAddTask_4 = new JButton("Add");
		btnAddTask_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_4.setBounds(375, 191, 51, 13);
		ctnAufgabe1.add(btnAddTask_4);
		btnAddTask_4.addActionListener(new UnserListener4());

		//"Add" Button for Task 5
		btnAddTask_5 = new JButton("Add");
		btnAddTask_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_5.setBounds(375, 214, 51, 13);
		ctnAufgabe1.add(btnAddTask_5);
		btnAddTask_5.addActionListener(new UnserListener5());

		//"Add" Button for Task 6
		btnAddTask_6 = new JButton("Add");
		btnAddTask_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_6.setBounds(375, 237, 51, 13);
		ctnAufgabe1.add(btnAddTask_6);
		btnAddTask_6.addActionListener(new UnserListener6());

		//"Add" Button for Task 7
		btnAddTask_7 = new JButton("Add");
		btnAddTask_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAddTask_7.setBounds(375, 260, 51, 13);
		ctnAufgabe1.add(btnAddTask_7);
		btnAddTask_7.addActionListener(new UnserListener7());

		/**
		 * 	Button to delete Task in the JLabel
		 * @author Felix
		 */
		
		//"Delete" Button for Task 1
		JButton btndelet_1 = new JButton("Delete");
		btndelet_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1.setBounds(319, 121, 58, 13);
		ctnAufgabe1.add(btndelet_1);
		btndelet_1.addActionListener(new UnserListener9());

		//"Delete" Button for Task 2
		JButton btndelet_1_1 = new JButton("Delete");
		btndelet_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_1.setBounds(319, 144, 58, 13);
		ctnAufgabe1.add(btndelet_1_1);
		btndelet_1_1.addActionListener(new UnserListener10());

		//"Delete" Button for Task 3
		JButton btndelet_1_2 = new JButton("Delete");
		btndelet_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_2.setBounds(319, 167, 58, 13);
		ctnAufgabe1.add(btndelet_1_2);
		btndelet_1_2.addActionListener(new UnserListener11());

		//"Delete" Button for Task 4
		JButton btndelet_1_3 = new JButton("Delete");
		btndelet_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_3.setBounds(319, 191, 58, 13);
		ctnAufgabe1.add(btndelet_1_3);
		btndelet_1_3.addActionListener(new UnserListener12());

		//"Delete" Button for Task 5
		JButton btndelet_1_4 = new JButton("Delete");
		btndelet_1_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_4.setBounds(319, 214, 58, 13);
		ctnAufgabe1.add(btndelet_1_4);
		btndelet_1_4.addActionListener(new UnserListener13());

		//"Delete" Button for Task 6
		JButton btndelet_1_5 = new JButton("Delete");
		btndelet_1_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_5.setBounds(319, 237, 58, 13);
		ctnAufgabe1.add(btndelet_1_5);
		btndelet_1_5.addActionListener(new UnserListener14());

		//"Delete" Button for Task 7
		JButton btndelet_1_6 = new JButton("Delete");
		btndelet_1_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btndelet_1_6.setBounds(319, 260, 58, 13);
		ctnAufgabe1.add(btndelet_1_6);

		/**
		 * Creates Button to open the Googlecalender im Browser
		 * @author Felix
		 */
		JButton btnOpenKalender = new JButton("Open Kalender");
		btnOpenKalender.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnOpenKalender.setBounds(319, 309, 107, 21);
		ctnAufgabe1.add(btnOpenKalender);
		btndelet_1_6.addActionListener(new UnserListener15());

		//"Add MouseListener to open the Calender
		btnOpenKalender.addMouseListener(new MouseAdapter (){
			@Override
			/**
			 * Open a Url in default Browser
			 * @param  url
			 * 		url to open
			 */
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://calendar.google.com/calendar/u/0/r").toURI());
				}
				/**
				 * Shows when there is a Problem in the Code, where the Problem is
				 */
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	/**
	 * Add Actionlistener to delet or add Task to the JLabels
	 * @author Felix
	 * 
	 * Add CalenderWrapper where will be checked if there is a date or not
	 * @author David
	 */
	
	//Add Task 1 to JLabelAufgabe1 an creates eventually a appointment 
	private class UnserListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a = txtEingabe.getText();
			lblAufgabe1.setText("1. "+a);
			/**
			 * 
			 */
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, a);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	//Add Task 2 to JLabelAufgabe2 an creates eventually a appointment
	private class UnserListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String b = txtEingabe.getText();
			lblAufgabe2.setText("2. "+b);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, b);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
	//Add Task 3 to JLabelAufgabe3 an creates eventually a appointment
	private class UnserListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String c = txtEingabe.getText();
			lblAufgabe3.setText("3. "+c);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, c);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	//Add Task 4 to JLabelAufgabe4 an creates eventually a appointment
	private class UnserListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String d = txtEingabe.getText();
			lblAufgabe4.setText("4. "+d);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, d);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	//Add Task 5 to JLabelAufgabe5 an creates eventually a appointment
	private class UnserListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String y= txtEingabe.getText();
			lblAufgabe5.setText("5. "+y);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, y);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	//Add Task 6 to JLabelAufgabe6 an creates eventually a appointment
	private class UnserListener6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String f = txtEingabe.getText();
			lblAufgabe6.setText("6. "+f);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, f);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	//Add Task 7 to JLabelAufgabe7 an creates eventually a appointment
	private class UnserListener7 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String g = txtEingabe.getText();
			lblAufgabe7.setText("7. "+g);
			try {
				Calendar service = CalenderWrapper.generateConnection();
				CalenderWrapper.createEvent(service, g);
			} catch (GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	/**
	 * Add ActionListener to delete the whole List
	 * @author Felix
	 *
	 */
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
	//Clears JLabelAufgabe1
	private class UnserListener9 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe1.setText("1. ");

		}

	}
	//Clears JLabelAufgabe2
	private class UnserListener10 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe2.setText("2. ");

		}

	}
	//Clears JLabelAufgabe3
	private class UnserListener11 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe3.setText("3. ");

		}

	}
	//Clears JLabelAufgabe4
	private class UnserListener12 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe4.setText("4. ");

		}

	}
	//Clears JLabelAufgabe5
	private class UnserListener13 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe5.setText("5. ");

		}

	}
	//Clears JLabelAufgabe6
	private class UnserListener14 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe6.setText("6. ");

		}

	}
	//Clears JLabelAufgabe6
	private class UnserListener15 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			lblAufgabe7.setText("7. ");

		}

	}
}

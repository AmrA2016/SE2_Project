

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Teacher_Student_Frame {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Student_Frame window = new Teacher_Student_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Teacher_Student_Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.type=0;
				l.frame.setVisible(true);
				frame.dispose();

				
			}
		});
		btnNewButton.setBounds(22, 97, 123, 65);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAdmin = new JButton("Teacher");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.type=1;
				l.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnAdmin.setBounds(339, 97, 123, 65);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(188, 185, 123, 65);
		frame.getContentPane().add(btnExit);
		
		JLabel lblWelcomeToOur = new JLabel("Welcome to our System ");
		lblWelcomeToOur.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOur.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblWelcomeToOur.setBounds(45, 11, 324, 39);
		frame.getContentPane().add(lblWelcomeToOur);
	}
}

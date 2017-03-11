import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Student_Home {

	JFrame frame;
	Student s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Home window = new Student_Home(new Student());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param s
	 */
	public Student_Home(Student s) {
		this.s = s;
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

		JLabel lblChooseASubject = new JLabel("Choose an Option");
		lblChooseASubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseASubject.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 14));
		lblChooseASubject.setBounds(145, 0, 200, 50);
		frame.getContentPane().add(lblChooseASubject);

		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(
						null,
						"Student Name: " + s.getName() + "\nStudent ID: "
								+ s.getID() + "\nStudent Password: "
								+ s.getPassword(), " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewProfile.setBounds(274, 66, 200, 50);
		frame.getContentPane().add(btnViewProfile);

		JButton btnPlayAGame = new JButton("Play A game");
		btnPlayAGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamesTypes g = new GamesTypes(s, 0);
				g.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPlayAGame.setBounds(10, 66, 200, 50);
		frame.getContentPane().add(btnPlayAGame);

		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(274, 152, 200, 50);
		frame.getContentPane().add(btnLogout);

		JButton btnShowScore = new JButton("View Score");
		btnShowScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, s.ShowScore(s.name),
						"All Scores", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnShowScore.setBounds(10, 152, 200, 50);
		frame.getContentPane().add(btnShowScore);
		DefaultListModel dlm = new DefaultListModel();
	}
}

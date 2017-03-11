import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddTOF1 {

	 JFrame frame;
	private JTextField q1;
	private JTextField q2;
	private JTextField q3;
	private JTextField q4;
	private JLabel lblQuestion_4;
	private JLabel lblQuestion_3;
	private JLabel lblQuestion_2;
	private JButton btnAdd;
Teacher t;
private JTextField title;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTOF1 window = new AddTOF1(new Teacher());
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
	public AddTOF1(Teacher t) {
		this.t=t;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Enter The Questions");
		q1 = new JTextField();
		q1.setBounds(162, 60, 262, 26);
		frame.getContentPane().add(q1);
		q1.setColumns(10);
		
		q2 = new JTextField();
		q2.setColumns(10);
		q2.setBounds(162, 97, 262, 26);
		frame.getContentPane().add(q2);
		
		q3 = new JTextField();
		q3.setColumns(10);
		q3.setBounds(162, 134, 262, 26);
		frame.getContentPane().add(q3);
		
		q4 = new JTextField();
		q4.setColumns(10);
		q4.setBounds(162, 171, 262, 26);
		frame.getContentPane().add(q4);
		
		JLabel lblQuestion = new JLabel("Question 1");
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion.setBounds(10, 60, 142, 26);
		frame.getContentPane().add(lblQuestion);
		
		lblQuestion_4 = new JLabel("Question 2");
		lblQuestion_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_4.setBounds(10, 97, 142, 26);
		frame.getContentPane().add(lblQuestion_4);
		
		lblQuestion_3 = new JLabel("Question 3");
		lblQuestion_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_3.setBounds(10, 134, 142, 26);
		frame.getContentPane().add(lblQuestion_3);
		
		lblQuestion_2 = new JLabel("Question 4");
		lblQuestion_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_2.setBounds(10, 171, 142, 26);
		frame.getContentPane().add(lblQuestion_2);
		
		btnAdd = new JButton("Add Answers");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String que[]= new String[6];
				que[0]=q1.getText();
				que[1]=q2.getText();
				que[2]=q3.getText();
				que[3]=q4.getText();
				que[4]=title.getText();
				
			AddTOF2 ad= new AddTOF2(t,que);
			ad.frmEnterTheAnswers.setVisible(true);
			frame.dispose();
				
			}
		});
		btnAdd.setBounds(304, 208, 120, 45);
		frame.getContentPane().add(btnAdd);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(162, 23, 262, 26);
		frame.getContentPane().add(title);
		
		JLabel lblTheTitleOf = new JLabel("The title of the Game");
		lblTheTitleOf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblTheTitleOf.setBounds(10, 23, 142, 26);
		frame.getContentPane().add(lblTheTitleOf);
	}
}

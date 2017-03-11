import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddMSQ2 {

	JFrame frmEnterTheAnswers;
	private JTextField a1;
	private JTextField a2;
	private JTextField a3;
	private JTextField a4;
	private JLabel lblQuestion_4;
	private JLabel lblQuestion_3;
	private JLabel lblQuestion_2;
	private JButton btnAdd;
	static String que[];
	static int index = 0;
	static ArrayList<String[]> Ans = new ArrayList<String[]>();
	Teacher t;
	private JTextField textField;
	private JTextField corr;
	private JLabel lblTheCorrectAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMSQ2 window = new AddMSQ2(new Teacher(), que);
					window.frmEnterTheAnswers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param que
	 */
	public AddMSQ2(Teacher t, String[] que) {
		initialize();
		this.que = que;
		this.t = t;
		textField.setText("Enter The Answers of Question " + (index + 1));
		a1.requestFocus();
		corr = new JTextField();
		corr.setColumns(10);
		corr.setBounds(162, 40, 262, 26);
		frmEnterTheAnswers.getContentPane().add(corr);
		
		lblTheCorrectAnswer = new JLabel("The Correct Answer");
		lblTheCorrectAnswer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblTheCorrectAnswer.setBounds(10, 40, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblTheCorrectAnswer);
		if (index == 3)
			btnAdd.setText("Add The Game");
		index++;
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnterTheAnswers = new JFrame();
		frmEnterTheAnswers.setBounds(100, 100, 450, 300);
		frmEnterTheAnswers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnterTheAnswers.getContentPane().setLayout(null);
		frmEnterTheAnswers.setTitle("Enter The Answers");
		a1 = new JTextField();
		a1.setBounds(162, 77, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a1);
		a1.setColumns(10);

		a2 = new JTextField();
		a2.setColumns(10);
		a2.setBounds(162, 108, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a2);

		a3 = new JTextField();
		a3.setColumns(10);
		a3.setBounds(162, 142, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a3);

		a4 = new JTextField();
		a4.setColumns(10);
		a4.setBounds(162, 172, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a4);

		JLabel lblQuestion = new JLabel("Answer 1");
		lblQuestion.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 15));
		lblQuestion.setBounds(10, 60, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion);

		lblQuestion_4 = new JLabel("Answer 2");
		lblQuestion_4.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 15));
		lblQuestion_4.setBounds(10, 97, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_4);

		lblQuestion_3 = new JLabel("Answer 3");
		lblQuestion_3.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 15));
		lblQuestion_3.setBounds(10, 134, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_3);

		lblQuestion_2 = new JLabel("Answer 4");
		lblQuestion_2.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 15));
		lblQuestion_2.setBounds(10, 171, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_2);

		btnAdd = new JButton("Enter The Next Question Answers");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aue[] = new String[5];
				aue[0] = a1.getText();
				aue[1] = a2.getText();
				aue[2] = a3.getText();
				aue[3] = a4.getText();
				aue[4]=corr.getText();
				Ans.add(aue);
				
				if (index == 4) {
					MSQ m = new MSQ();
					m.WriteGame(que, Ans);
					Teacher_Home th = new Teacher_Home(t);
					th.frame.setVisible(true);
					frmEnterTheAnswers.dispose();
					Ans.clear();
					index=0;
				} else {
					AddMSQ2 ad = new AddMSQ2(t, que);
					ad.frmEnterTheAnswers.setVisible(true);
					frmEnterTheAnswers.dispose();
				}

			}
		});
		btnAdd.setBounds(216, 216, 208, 45);
		frmEnterTheAnswers.getContentPane().add(btnAdd);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				17));
		textField.setBounds(78, 0, 278, 32);
		frmEnterTheAnswers.getContentPane().add(textField);
		textField.setColumns(10);
	}

}

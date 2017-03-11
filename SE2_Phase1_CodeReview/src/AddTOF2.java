import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddTOF2 {

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
	Teacher t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTOF2 window = new AddTOF2(new Teacher(),que);
					window.frmEnterTheAnswers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param que 
	 */
	public AddTOF2(Teacher t,String[] que) {
		this.que=que;
		this.t=t;
		initialize();
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
		a1.setBounds(162, 60, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a1);
		a1.setColumns(10);
		
		a2 = new JTextField();
		a2.setColumns(10);
		a2.setBounds(162, 97, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a2);
		
		a3 = new JTextField();
		a3.setColumns(10);
		a3.setBounds(162, 134, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a3);
		
		a4 = new JTextField();
		a4.setColumns(10);
		a4.setBounds(162, 171, 262, 26);
		frmEnterTheAnswers.getContentPane().add(a4);
		
		JLabel lblQuestion = new JLabel("Answer 1");
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion.setBounds(10, 60, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion);
		
		lblQuestion_4 = new JLabel("Answer 2");
		lblQuestion_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_4.setBounds(10, 97, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_4);
		
		lblQuestion_3 = new JLabel("Answer 3");
		lblQuestion_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_3.setBounds(10, 134, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_3);
		
		lblQuestion_2 = new JLabel("Answer 4");
		lblQuestion_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblQuestion_2.setBounds(10, 171, 142, 26);
		frmEnterTheAnswers.getContentPane().add(lblQuestion_2);
		
		btnAdd = new JButton("Add this game");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aue[]= new String[4];
				aue[0]=a1.getText();
				aue[1]=a2.getText();
				aue[2]=a3.getText();
				aue[3]=a4.getText();
				TOF tof = new TOF();
				tof.WriteGame(que, aue);
				Teacher_Home th= new Teacher_Home(t);
				th.frame.setVisible(true);
				frmEnterTheAnswers.dispose();
				
			}
		});
		btnAdd.setBounds(304, 208, 120, 45);
		frmEnterTheAnswers.getContentPane().add(btnAdd);
	}

}

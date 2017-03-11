import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PlayTOF {

	JFrame frame;
	private JTextField textField;
	Student s;
	TOF t;
	static int ind=0;
	JLabel lblQuestionn;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayTOF window = new PlayTOF(new Student(),new TOF());
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
	public PlayTOF(Student s, TOF t) {
		this.s=s;
		this.t=t;
		initialize();
		lblQuestionn.setText("Question Number: " + (ind+1));
		lblNewLabel.setText(t.questions[ind]);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 lblQuestionn = new JLabel("QuestionN");
		lblQuestionn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblQuestionn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionn.setBounds(119, 10, 200, 50);
		frame.getContentPane().add(lblQuestionn);
		
		 lblNewLabel = new JLabel("How Are You");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 71, 262, 68);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 262, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(t.answers[ind]))
					{JOptionPane.showMessageDialog(null, "Correct Answer!", "Success!",
							JOptionPane.INFORMATION_MESSAGE);	
					s.score++;
					}
				else 
					JOptionPane.showMessageDialog(null, "Wrong Answer! and the correct is " + t.answers[ind], "Fail!",
							JOptionPane.ERROR_MESSAGE);
					ind++;
					if(ind==4)
					{
						s.WriteScore("TOF");
						Student_Home sh=new Student_Home(s);
						sh.frame.setVisible(true);
						frame.dispose();
						ind=0;
					}
					PlayTOF p = new PlayTOF(s, t);
					p.frame.setVisible(true);
					frame.dispose();
						
			}
		});
		btnNewButton.setBounds(335, 210, 89, 40);
		frame.getContentPane().add(btnNewButton);
	}
}

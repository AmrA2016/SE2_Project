import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PlayMSQ {

	JFrame frame;
	Student s;
	MSQ t;
	static int ind = 0;
	JLabel lblQuestionn;
	JLabel lblNewLabel;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JRadioButton r4;
	ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayMSQ window = new PlayMSQ(new Student(), new MSQ());
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
	public PlayMSQ(Student s, MSQ t) {
		this.s = s;
		this.t = t;
		initialize();
		lblQuestionn.setText("Question Number: " + (ind + 1));
		lblNewLabel.setText(t.questions[ind]);

		r1 = new JRadioButton("New radio button");
		r1.setBounds(10, 137, 123, 50);
		frame.getContentPane().add(r1);
		r1.setText(t.ans.get(ind)[0]);

		r2 = new JRadioButton("New radio button");
		r2.setBounds(135, 137, 123, 50);
		frame.getContentPane().add(r2);
		r2.setText(t.ans.get(ind)[1]);

		r3 = new JRadioButton("New radio button");
		r3.setBounds(135, 190, 123, 50);
		frame.getContentPane().add(r3);
		r3.setText(t.ans.get(ind)[2]);

		r4 = new JRadioButton("New radio button");
		r4.setBounds(10, 193, 123, 50);
		frame.getContentPane().add(r4);
		r4.setText(t.ans.get(ind)[3]);

		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);

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
		lblQuestionn.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 14));
		lblQuestionn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestionn.setBounds(119, 10, 200, 50);
		frame.getContentPane().add(lblQuestionn);

		lblNewLabel = new JLabel("How Are You");
		lblNewLabel.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 71, 262, 40);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean happended=false;
				if (r1.isSelected() && r1.getText().equals(t.ans.get(ind)[4])) {
					JOptionPane.showMessageDialog(null, "Correct Answer!",
							"Success!", JOptionPane.INFORMATION_MESSAGE);
					s.score++;
					happended=true;
				}
				if (r2.isSelected() && r2.getText().equals(t.ans.get(ind)[4])) {
					JOptionPane.showMessageDialog(null, "Correct Answer!",
							"Success!", JOptionPane.INFORMATION_MESSAGE);
					s.score++;
					happended=true;
				}
				if (r3.isSelected() && r3.getText().equals(t.ans.get(ind)[4])) {
					JOptionPane.showMessageDialog(null, "Correct Answer!",
							"Success!", JOptionPane.INFORMATION_MESSAGE);
					s.score++;
					happended=true;
				}
				if (r4.isSelected() && r4.getText().equals(t.ans.get(ind)[4])) {
					JOptionPane.showMessageDialog(null, "Correct Answer!",
							"Success!", JOptionPane.INFORMATION_MESSAGE);
					s.score++;
					happended=true;
				} 
				if(!happended) 
					JOptionPane.showMessageDialog(
							null,
							"Wrong Answer! and the correct is "
									+ t.ans.get(ind)[4], "Fail!",
							JOptionPane.ERROR_MESSAGE);
					ind++;
				
				if(ind==4)
				{
					s.WriteScore("MSQ");
					Student_Home sh=new Student_Home(s);
					sh.frame.setVisible(true);
					frame.dispose();
					ind=0;
				}
				else 
				{
					PlayMSQ p = new PlayMSQ(s, t);
					p.frame.setVisible(true);
					frame.dispose();
				}
				
			}
		});
		btnNewButton.setBounds(335, 210, 89, 40);
		frame.getContentPane().add(btnNewButton);
	}
}

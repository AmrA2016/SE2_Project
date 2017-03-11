

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	 JFrame frame;
	private JTextField name;
	private JTextField pass;
	private JButton btnSignUp;
	int type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp(0);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param type 
	 */
	public SignUp(int type) {
		this.type=type;
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
		
		JLabel lblEnterUserName = new JLabel("Enter User Name");
		lblEnterUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterUserName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblEnterUserName.setBounds(10, 39, 172, 50);
		frame.getContentPane().add(lblEnterUserName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblEnterPassword.setBounds(10, 122, 172, 50);
		frame.getContentPane().add(lblEnterPassword);
		
		name = new JTextField();
		name.setBounds(201, 39, 223, 50);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(201, 122, 223, 50);
		frame.getContentPane().add(pass);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type==0)
				{
					Student s = new Student();
					s.SignUp(name.getText(),pass.getText());
					
						
						JOptionPane.showMessageDialog(null, "Welcome!", "",
								JOptionPane.INFORMATION_MESSAGE);
						Student_Home st=new Student_Home(s);
						st.frame.setVisible(true);
						frame.dispose();
						
					
				}
				else 
				{
					Teacher t = new Teacher();
					t.SignUp(name.getText(),pass.getText());
					
						JOptionPane.showMessageDialog(null, "Welcome!", "",
								JOptionPane.INFORMATION_MESSAGE);
						Teacher_Home st=new Teacher_Home(t);
						st.frame.setVisible(true);
						frame.dispose();
						
					

				}
			
			}
		});
		btnSignUp.setBounds(324, 206, 89, 44);
		frame.getContentPane().add(btnSignUp);
	}

}



import java.awt.Color;
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


public class Login {

	JFrame frame;

	private JTextField name;
	private JTextField pass;

	protected int type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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

		name = new JTextField();
		name.setBounds(155, 79, 319, 38);
		frame.getContentPane().add(name);
		name.setColumns(10);
		name.requestFocus();
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(155, 128, 319, 38);
		frame.getContentPane().add(pass);

		JLabel lblNewLabel = new JLabel(
				"Enter A valid UserName and password to login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(83, 11, 347, 48);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 14));
		lblNewLabel_1.setBounds(35, 79, 110, 38);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman",
				Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(35, 128, 110, 38);
		frame.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type==0)
				{
					Student s = new Student();
					boolean b=s.Signin(name.getText(),pass.getText());
					if(!b)
						JOptionPane.showMessageDialog(null,
								"Wrong Password or Email , Try Again",
								"Login Failed", JOptionPane.ERROR_MESSAGE);
					else 
					{
						
						JOptionPane.showMessageDialog(null, "Welcome!", "",
								JOptionPane.INFORMATION_MESSAGE);
						Student_Home st=new Student_Home(s);
						st.frame.setVisible(true);
						frame.dispose();
						
					}
				}
				else 
				{
					Teacher t = new Teacher();
					boolean b=t.Signin(name.getText(),pass.getText());
					if(!b)
						JOptionPane.showMessageDialog(null,
								"Wrong Password or Email , Try Again",
								"Login Failed", JOptionPane.ERROR_MESSAGE);
					else 
					{
						JOptionPane.showMessageDialog(null, "Welcome!", "",
								JOptionPane.INFORMATION_MESSAGE);
						Teacher_Home st=new Teacher_Home(t);
						st.frame.setVisible(true);
						frame.dispose();
						
					}

				}
			
			}
		});
		btnLogin.setBounds(371, 227, 89, 23);
		frame.getContentPane().add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(35, 227, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp si = new SignUp(type);
				si.frame.setVisible(true);frame.dispose();
			}
		});
		btnSignup.setBounds(198, 227, 89, 23);
		frame.getContentPane().add(btnSignup);
	}
}

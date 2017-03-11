import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class GamesTypes {

	 JFrame frame;
int type;
static Account t;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamesTypes window = new GamesTypes(t,0);
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
	public GamesTypes(Account t,int type) {
		this.t=t;
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
		
		JLabel lblNewLabel = new JLabel("Choose the Type of the game");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 30, 241, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnTof = new JButton("TOF");
		btnTof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(type==1)
				{
					AddTOF1 ad=new AddTOF1((Teacher) t);
					ad.frame.setVisible(true);
					frame.dispose();
				}
				else 
				{
					SelectTOF st= new SelectTOF((Student) t);
					st.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnTof.setBounds(10, 144, 200, 50);
		frame.getContentPane().add(btnTof);
		
		JButton btnMsq = new JButton("MSQ");
		btnMsq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(type==1)
				{
					AddMSQ1 ad=new AddMSQ1((Teacher) t);
					ad.frame.setVisible(true);
					frame.dispose();
				}
				else 
				{
					SelectMSQ sm = new SelectMSQ((Student) t);
					sm.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMsq.setBounds(224, 144, 200, 50);
		frame.getContentPane().add(btnMsq);
	}
}

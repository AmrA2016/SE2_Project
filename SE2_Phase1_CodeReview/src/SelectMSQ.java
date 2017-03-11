import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class SelectMSQ {

	JFrame frame;
	Student s;
	JList list;
	ArrayList<MSQ> MSQs = new ArrayList<MSQ>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectMSQ window = new SelectMSQ(new Student());
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
	public SelectMSQ(Student s) {
		this.s=s;
		initialize();
		File f = new File("MSQ.txt");
		ArrayList<String[]>arr = new ArrayList<String[]>();
			try {
				Scanner in = new Scanner(f);
				String str[] = new String[5];
				
				while (in.hasNextLine()) {
					String[] text = in.nextLine().split(",");
					MSQ g = new MSQ();
					g.questions = new String[4];
					g.title = text[0];
					int cntr = 1;
					for (int i = 0; i < 4; i++) {
						g.questions[i] = text[cntr++];
						str= new String[5];
						str[4]=text[cntr++];
						for (int j = 0; j < 4; j++)
							str[j] = text[cntr++];
							arr.add(str);
						
						
					}
					
					g.ans=arr;
					MSQs.add(g);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DefaultListModel dlm = new DefaultListModel();
			for(int i=0;i<MSQs.size();i++)
			{
				dlm.addElement(MSQs.get(i).title);
			}
			list.setModel(dlm);
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblChooseTheGame = new JLabel("Choose The Game");
		lblChooseTheGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTheGame.setFont(new Font("Times New Roman", Font.BOLD
				| Font.ITALIC, 15));
		lblChooseTheGame.setBounds(111, 10, 200, 50);
		frame.getContentPane().add(lblChooseTheGame);

		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PlayMSQ m = new PlayMSQ(s, MSQs.get(list.getSelectedIndex()));
				m.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnPlay.setBounds(315, 211, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		 list = new JList();
		list.setBounds(10, 72, 251, 163);
		frame.getContentPane().add(list);
	}
}

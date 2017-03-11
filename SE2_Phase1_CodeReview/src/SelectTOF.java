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

public class SelectTOF {

	JFrame frame;
	Student s;
	JList list;
	ArrayList<TOF> tOFs = new ArrayList<TOF>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTOF window = new SelectTOF(new Student());
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
	public SelectTOF(Student s) {
		this.s=s;
		initialize();
		File f = new File("TOF.txt");
		
			try {
				Scanner in = new Scanner(f);
				while (in.hasNextLine()) {
					String[] text = in.nextLine().split(",");
					TOF g = new TOF();
					g.questions = new String[4];
					g.answers = new String[4];
					g.title=text[0];
					for (int i = 0; i < 4; i++)
						g.questions[i] = text[i+1];
					for (int i = 0; i < 4; i++)
						g.answers[i] = text[i + 5];
					tOFs.add(g);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DefaultListModel dlm = new DefaultListModel();
			for(int i=0;i<tOFs.size();i++)
			{
				//System.out.println(tOFs.get(i).title);
				dlm.addElement(tOFs.get(i).title);
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
				PlayTOF pl= new PlayTOF(s, tOFs.get(list.getSelectedIndex()));
				pl.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPlay.setBounds(315, 211, 89, 23);
		frame.getContentPane().add(btnPlay);
		
		 list = new JList();
		list.setBounds(10, 57, 246, 193);
		frame.getContentPane().add(list);
	}
}

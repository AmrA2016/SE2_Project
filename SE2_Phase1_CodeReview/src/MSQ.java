import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MSQ {
	String[] questions;
	ArrayList<String[]> ans = new ArrayList<String[]>();
	String title;

	void WriteGame(String[] questions, ArrayList<String[]> answers) {
		File f = new File("MSQ.txt");
		ArrayList<MSQ> MSQs = new ArrayList<MSQ>();
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
					str[4]=text[cntr++];
					for (int j = 0; j < 4; j++)
						str[j] = text[cntr++];
						
					g.ans.add(str);
				}
				MSQs.add(g);
			}
			MSQ g = new MSQ();
			g.questions = new String[4];
			for (int i = 0; i < 4; i++) {
				g.questions[i] = questions[i];
				for (int j = 0; j < 4; j++)
					{str[j] = answers.get(i)[j];
					}
				g.ans.add(str);
			}
			g.ans=answers;
			
			g.title = questions[4];
			MSQs.add(g);
			in.close();
			PrintWriter pw = new PrintWriter("MSQ.txt");
			for (int i = 0; i < MSQs.size(); i++) {
				pw.print(MSQs.get(i).title + ",");
				for (int j = 0; j < 4; j++) {
					if(j==0)
					pw.print(MSQs.get(i).questions[j] + ",");
					else 
						pw.print(","+MSQs.get(i).questions[j] + ",");
					pw.print(MSQs.get(i).ans.get(j)[4]+",");
					for (int k = 0; k < 3; k++)
						pw.print(MSQs.get(i).ans.get(j)[k] + ",");
					
						pw.print(MSQs.get(i).ans.get(j)[3]);
				}
				if (i != MSQs.size() - 1)
					pw.println();

			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

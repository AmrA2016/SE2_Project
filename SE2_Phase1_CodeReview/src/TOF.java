import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TOF {

	String[] questions;
	String[] answers;
	String title;

	void WriteGame(String[] questions, String[] answers) {
		File f = new File("TOF.txt");
		ArrayList<TOF> tOFs = new ArrayList<TOF>();
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
			TOF g = new TOF();
			g.questions = new String[4];
			g.answers = new String[4];
			for (int i = 0; i < 4; i++)
				g.questions[i] = questions[i];
			for (int i = 0; i < 4; i++)
				g.answers[i] = answers[i];
			g.title=questions[4];
			tOFs.add(g);
			in.close();
			PrintWriter pw = new PrintWriter("TOF.txt");
			for (int i = 0; i < tOFs.size(); i++) {
				pw.print(tOFs.get(i).title+",");
				for (int j = 0; j < 4; j++)
					pw.print(tOFs.get(i).questions[j] + ",");
				for (int j = 0; j < 3; j++)
					pw.print(tOFs.get(i).answers[j] + ",");
				pw.print(tOFs.get(i).answers[3]);
				if(i!=tOFs.size()-1)
				pw.println();
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

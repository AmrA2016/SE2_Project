import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Account {
	int score = 0;

	boolean Signin(String name, String pass) {

		File f = new File("Students.txt");
		try {
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				String[] line = in.nextLine().split(",");
				if (line[0].equals(name) && line[1].equals(pass)) {
					this.name = name;
					this.password = pass;
					ID = Integer.parseInt(line[2]);
					return true;

				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	void WriteScore(String t) {
		File f = new File("Scores.txt");
		ArrayList<String> arr = new ArrayList<String>();
		try {
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				arr.add(in.nextLine());
			}
			String e = name + "," + score + "," + t;
			arr.add(e);
			in.close();
			PrintWriter pw = new PrintWriter(f);
			for (int i = 0; i < arr.size() - 1; i++)
				pw.println(arr.get(i));
			pw.print(arr.get(arr.size() - 1));
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		score = 0;

	}

	@Override
	void SignUp(String name, String pass) {
		// TODO Auto-generated method stub
		File f = new File("Students.txt");
		try {
			Scanner in = new Scanner(f);
			ArrayList<String> us = new ArrayList<String>();
			while (in.hasNextLine()) {
				String line = in.nextLine();
				us.add(line);
			}
			in.close();
			PrintWriter pw = new PrintWriter(f);
			for (int i = 0; i < us.size(); i++)
				pw.println(us.get(i));
			pw.print(name + "," + pass + "," + ID);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

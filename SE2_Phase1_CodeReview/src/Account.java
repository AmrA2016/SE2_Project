import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Account {
	int ID;
	String name;
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract boolean Signin(String name, String pass);

	abstract void SignUp(String name, String pass);

	public String ShowScore(String name) {
		String text = "";
		File f = new File("Scores.txt");
		try {
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				String line[] = in.nextLine().split(",");
				
				if (line[0].equals(name) || name.equals("")) {
					if (name.equals(""))
						text += "Student: " + line[0] + " has a Score: "
								+ line[1] + " in game: " + line[2] + "\n";
					else
						text += "Score: " + line[1] + " in game: " + line[2]
								+ "\n";
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;
	}

}

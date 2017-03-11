import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeacherTest {

	Teacher teacherObject;
	ArrayList<String> fileDataBackup;
	File file;
	Scanner fin;
	PrintWriter pw;

	@BeforeMethod
	public void init() {
		teacherObject = new Teacher();
		fileDataBackup = new ArrayList<String>();
		file = new File("Teachers.txt");

		try {
			fin = new Scanner(file);

			while (fin.hasNextLine()) {
				fileDataBackup.add(fin.nextLine());
			}

			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

	@DataProvider(name = "input")
	public static Object[][] dp() {
		return new Object[][] { { "T1", "12345", true }, { "T2", "12345", false }, { "t3", "12345", false }};
	}

	@DataProvider(name = "input2")
	public Object[][] dp2() {
		return new Object[][] { { "X", "123", true }, { "Y", "", false }, { "", "123", false } };
	}

	@Test(dataProvider = "input")
	public void Signin(String username, String Password, boolean x) {
		Teacher newTeacher = new Teacher();
		Assert.assertEquals(newTeacher.Signin(username, Password), x);

	}

	@Test(dataProvider = "input2")
	public void SignUpTest(String username, String pass, boolean expected) {
		teacherObject.SignUp(username, pass);

		Assert.assertEquals(teacherObject.Signin(username, pass), expected);
	}

	@AfterMethod
	public void finalize() {
		try {
			pw = new PrintWriter(file);

			for (String element : fileDataBackup) {
				pw.println(element);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TOFTest {

	TOF tofObject;
	ArrayList<String> fileDataBackup;
	File file;
	Scanner fin;
	PrintWriter pw;

	@BeforeMethod
	public void beforeMethod() {

		tofObject = new TOF();
		fileDataBackup = new ArrayList<String>();
		file = new File("TOF.txt");

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


	@Test
	public void WriteGameTest() {
		boolean found = false;
		String title = "Arthmetic";
		String questions[] = new String[] { "4+19", "6*7", "54/6", "65-7", title };
		String answers[] = new String[] { "23", "42", "9", "58" };
		
		tofObject.WriteGame(questions, answers);
		
		try {
			fin = new Scanner(file);
			
			while(fin.hasNextLine()){
				String parts[] = fin.nextLine().split(",");
				if(parts[0].equals(title)){
					for(int i =0;i < 4;i++){
						Assert.assertEquals(parts[i+1], questions[i]);
						Assert.assertEquals(parts[i+5], answers[i]);
					}
					
					found = true;
					break;
				}
			}
			
			Assert.assertTrue(found);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class I {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("d:\\1.txt");
		InputStream is = new FileInputStream(file);
		
		Scanner sc =new  Scanner(is);
		String str = sc.next();
		while(!str.equals(":quit"))
		{
			System.out.println(str);
			 str = sc.next();
		}
	}
}

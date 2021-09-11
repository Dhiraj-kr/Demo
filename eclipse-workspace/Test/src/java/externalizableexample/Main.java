package java.externalizableexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) 
		throws Exception {
		
		User userWrite = new User(1, "johndoe", "John Doe");
		FileOutputStream fos = new FileOutputStream("testfile");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(userWrite);
		oos.flush();
		oos.close();

		User userRead;
		FileInputStream fis = new FileInputStream("testfile");
		ObjectInputStream ois = new ObjectInputStream(fis);
		userRead = (User)ois.readObject();
		ois.close();
		
		System.out.println("username: " + userRead.getUsername());

	}

}

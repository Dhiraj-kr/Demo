package test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IO {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\home\\joe\\foo");

		// Solaris syntax
		//Path path = Paths.get("/home/joe/foo");
		System.out.println(path.getName(0)+", "+path.subpath(0,2)+", "+path.getParent()+", "+
		path.getRoot());

	}
}

package file;

import java.io.RandomAccessFile;

public class RandomAccess2 {
  public static void main(String[] argv) throws Exception {
    RandomAccessFile file = new RandomAccessFile("E:/files/scores.txt", "rw");
    for (int i = 1; i <= 6; i++) {
      System.out.println(file.readLine());
    }
    long current = file.getFilePointer();
    //file.seek(0);
    file.seek(current + 6);
    file.write("34".getBytes());
    for (int i = 1; i <= 5; i++) {
      System.out.println(file.readLine());
    }
    current = file.getFilePointer();
    file.seek(current + 6);
    file.write("27".getBytes());
    file.close();
  }
}
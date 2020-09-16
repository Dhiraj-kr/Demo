package file;

import java.io.RandomAccessFile;

public class ReverseFile {
  public static void main(String[] argv) throws Exception {

    RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
    int x, y;

    for (long i = 0, j = raf.length() - 1; i < j; i++, j--) {
      raf.seek(i);
      x = raf.read();
      //System.out.println(x);
      raf.seek(j);
      y = raf.read();
      //System.out.println(y);

      raf.seek(j);
      raf.write(x);
      raf.seek(i);
      raf.write(y);

    }
    raf.close();
  }
}

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Vorlesungsaufgaben {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\Yannick\\Desktop\\test.txt");
        File f2 = new File("C:\\Users\\Yannick\\Desktop\\test2.txt");
        copy(f1, f2);
        cat(f1);
    }

    public static void copy(File from, File to) throws IOException {
        RandomAccessFile in = null;
        RandomAccessFile out = null;
        try {
            in = new RandomAccessFile(from, "r");
            out = new RandomAccessFile(to, "rw");
            int copy;
            while((copy = in.read()) >= 0)
                out.write(copy);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }       
    }   

    public static void cat(File quelle) throws IOException {
        try (RandomAccessFile in = new RandomAccessFile(quelle, "r")) {
            String output;
            while((output = in.readLine()) != null)
                System.out.println(output);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

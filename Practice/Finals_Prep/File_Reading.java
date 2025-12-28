import java.io.*;

public class File_Reading {
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("a.txt"); fw.write("X"); fw.close();
        FileWriter fw2 = new FileWriter("a.txt", true); fw2.write("Y"); fw2.close();

        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        System.out.println(br.readLine());
    }
}

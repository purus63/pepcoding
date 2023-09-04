package Faang;

import java.io.*;

public class MTest {
    public static void main(String[] args) throws IOException {
        File f = new File("/home/purus63/joyoflife/ProblemsSolving/src/Temprature.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line=br.readLine())!=null)
        {
            String rec[]= line.split(",");
            for(String s:rec)
                System.out.println(s);
        }




    }
}

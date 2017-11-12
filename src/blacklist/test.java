package blacklist;
import java.io.*;


public class test {


    public static void main(String[] args) {
        String msg;
        File file1 = new File("D:/blacklist.txt");
       if (file1.exists())
           System.out.println("yes");
            Userget userget = new Userget();
             userget.go();
             Userout userout = new Userout();



    }
}

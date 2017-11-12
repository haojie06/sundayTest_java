package blacklist;
import java.io.*;
import java.util.TreeSet;

public class Userout {
    File outFile = new File("D:/newblacklist.txt");
    public void out(TreeSet<User> userTreeSet) {
        try{

            //将文件输出
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outFile),"iso-8859-1");
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            for (User user : userTreeSet)
            {
                writer.write(user.getUserName() + user.getUserIp()+"\n");
            }
            writer.close();

        }catch (IOException ex){}
    }


}

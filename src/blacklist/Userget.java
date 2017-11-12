package blacklist;


import java.io.*;
import java.util.*;


public class Userget {

    ArrayList<User> usersList = new ArrayList<User>();

    public void go(){
        getUser();
        LengthCompare lengthCompare = new LengthCompare();
        TreeSet<User> usersSet = new TreeSet<User>(lengthCompare);
        usersSet.addAll(usersList);
        for(User user : usersSet ){
            System.out.println(user.getUserName() + " " + user.getUserIp());
        }

        Userout userout = new Userout();
        userout.out(usersSet);
    }


    public void getUser()
    {
        try {
            File file = new File("D:/blacklist.txt");
            String input;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((input = reader.readLine()) != null) {
                addUser(input);
            }

        }catch (IOException ex){ex.printStackTrace();}
    }

    void addUser(String str){
        String[] token = str.split(" ");
        User blockUser = new User(token[0],token[1]);
        usersList.add(blockUser);
    }

    //创建一个比较器
    class LengthCompare implements Comparator<User>{
        public int compare(User one,User two){
            if(one.length < two.length)
                return -1;
            else if (one.length == two.length)
                return 0;
            else
                return 1;
        }
    }






}

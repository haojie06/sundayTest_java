package blacklist;

public class User {
    private String userName;
    private String userIp;
    public int length;
    /**
     * 如果对象类型是User 的话 则返回true 去比较hashCode值
     */
    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        return getUserIp().equals(u.getUserIp());
    }
    //重写HASHCODE
    @Override
    public int hashCode() {
        return userName.hashCode() * userIp.hashCode();
    }




    //构造方法
    public User(String Name,String Ip){
        userName = Name;
        userIp = Ip;
        length = userIp.length() + userName.length();
    }


    public int compareTo(User user){
        return userName.compareTo(user.getUserName());
    }

    //setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    //getter
    public String getUserName() {
        return userName;
    }

    public String getUserIp() {
        return userIp;
    }
}

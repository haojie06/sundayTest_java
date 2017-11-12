package Thread;
/*

多线程有严重错误，无法解决，一个方法不能执行完，使用同步锁又无法模拟。
*/

public class Versus {
    Wall wall = new Wall();
    //挖墙成功次数
    static int count;

    public static void main(String[] args) {
        Versus Vs = new Versus();
        Vs.go();
    }


    public void go() {
        Runnable boyJob = new Dig();
        Runnable girlJob = new Repair();

        Thread boy1 = new Thread(boyJob);
        Thread boy2 = new Thread(boyJob);
        Thread girl1 = new Thread(girlJob);
        Thread girl2 = new Thread(girlJob);

        boy1.setName("男生1");
        boy2.setName("男生2");

        girl1.setName("女生1");
        girl2.setName("女生2");


            boy1.start();
            boy2.start();

                girl1.start();
                girl2.start();

        if (wall.bricks <= 0)
            count += 1;


    }

    //挖墙任务
    class Dig implements Runnable {
        public void run() {
            String threadname = Thread.currentThread().getName();
            if (wall.bricks == 0)
                System.out.println("墙已挖完" + threadname + "看妹子");

                while (wall.bricks != 0) {
                    wall.DigWall();
                    //挖完后再进行判断
                    if (wall.bricks == 0)
                    {
                        System.out.println(threadname + "把墙挖穿了，看妹子~");}
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){ex.printStackTrace();}
                }

            }
        }



    //补墙任务
    class Repair implements Runnable {
        public void run() {
            String threadname = Thread.currentThread().getName();
                    while (wall.bricks != 200)
                    {
                        wall.RepairWall(1);
                        //补墙后进行判断
                    if (wall.bricks == 200)
                        System.out.println(threadname + "把墙补上了，开始化妆");
                        try {
                            Thread.sleep(500);
                        }catch (InterruptedException ex){ex.printStackTrace();}

            }
        }
    }
}
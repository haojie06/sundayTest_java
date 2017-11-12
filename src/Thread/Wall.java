package Thread;

public class Wall {
    int bricks = 200;

    public  void DigWall(){
        bricks -= 2;
        System.out.println(Thread.currentThread().getName() + "挖掉两块砖还剩" + bricks);

    }

    public  void RepairWall(int r){
        bricks += r;
        System.out.println(Thread.currentThread().getName() + "补上一块，现在有砖" + bricks);

    }
}
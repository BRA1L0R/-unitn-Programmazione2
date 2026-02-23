package lecture05.inheritance;
public class Creeper extends Entity {
    public void hiss() {
        System.out.println("Hisss");
    }
    public Creeper(int x){
        System.out.print(" in Creeper() ");
    }
    public Creeper(int x, int y){
        super(x, y);
        System.out.print(" in Creeper(x,y) ");
    }
}
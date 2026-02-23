package lecture06;
import lecture06.abstracts.blocks.Dirt;
import lecture06.abstracts.entities.Chicken;
import lecture06.abstracts.entities.Wolf;
import lecture06.overloading.Pick;
import lecture06.overriding.Andesite;
import lecture06.overriding.Bedrock;
import lecture06.overriding.GoldBlock;
public class Lecture6 {
    public static void main(String[] args) {
        System.out.println("---------------- Classi astratte ----------------");
        abstractExample();
        System.out.println("---------------- Metodi astratti ----------------");
        abstractMethodsExample();
        System.out.println("---------------- Overriding e super ----------------");
        overridingExample();
        System.out.println("---------------- Overloading ----------------");
        overloadingExample();
    }
    private static void abstractExample(){
        Chicken c = new Chicken();
        Wolf w = new Wolf();
        c.teleport(10, 20);
        w.teleport(20,30);
        c.makeSound();
    }
    private static void abstractMethodsExample(){
        Dirt d = new Dirt();
        System.out.println("Received: " + d.mineWithDrop());
    }
    private static void overridingExample() {
        GoldBlock gb = new GoldBlock();
        gb.mine();
        Andesite a = new Andesite();
        a.mine();
        Bedrock br = new Bedrock();
        br.mine();
    }
    private static void overloadingExample(){
        Pick p = new Pick();
        p.use(new Dirt());
        p.use(new Bedrock());
        p.use(new Chicken());
    }
}
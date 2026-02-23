package lecture15;
import lecture07.interfaces.Skeleton;
import lecture14.Spawner;
import lecture07.interfaces.Zombie;
public class Lecture15 {
    public static void main(String[] args) {
        step_typerErasure();
    }
    private static void step_typerErasure() {
        System.out.println("\n=== 5. Parametricity ===");
        Spawner<Zombie> zSpawner = new Spawner<>();
        Spawner<Skeleton> sSpawner = new Spawner<>();
        Class<?> c1 = zSpawner.getClass();
        Class<?> c2 = sSpawner.getClass();
        System.out.println("Are they the same class? " + (c1 == c2));
        System.out.println("Class Name: " + c1.getName());
    }
}
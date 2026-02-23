package lecture14;
import lecture05.inheritance.Creeper;
import lecture05.inheritance.Entity;
import lecture05.inheritance.Zombie;
public class Lecture14 {
    public static void main(String[] args) {
        System.out.println("=== PART A: GENERICS BASICS ===");
        step1_rawTypesCrash();
        step2_generics();
        step3_invariance();
        step4_arrayCovariance();
        System.out.println("\n=== PART B: WILDCARDS & FLEXIBILITY ===");
        step2_covariance_Extends();
        step3_contravariance_Super();
        step4_PECS();
    }
    public static void step1_rawTypesCrash() {
        System.out.println("=== 1. Raw Types ===");
        RawSpawner mySpawner = new RawSpawner();
        mySpawner.setEntity(new Zombie());
    }
    private static void step2_generics() {
        System.out.println("\n=== 2. Generic Safety ===");
        Spawner<Zombie> zombieSpawner = new Spawner<>();
        zombieSpawner.setEntity(new Zombie());
        Zombie z = zombieSpawner.spawn();
    }
    private static void step3_invariance() {
        Spawner<Zombie> zombieSpawner = new Spawner<>();
    }
    private static void step4_arrayCovariance() {
        System.out.println("\n=== 4. Array Covariance (Dangerous) ===");
        Zombie[] zombieArray = new Zombie[1];
        Entity[] entityArray = zombieArray;
        entityArray[0] = new Creeper(5);
    }
    private static void step2_covariance_Extends() {
        System.out.println("=== 2. Covariance (? extends) ===");
        Spawner<Zombie> zombieSpawner = new Spawner<>();
        zombieSpawner.setEntity(new Zombie());
        Spawner<? extends Entity> source = zombieSpawner;
        Entity e = source.spawn();
        System.out.println("Spawned: " + e);
    }
    private static void step3_contravariance_Super() {
        System.out.println("\n=== 3. Contravariance (? super) ===");
        Spawner<Entity> generalSpawner = new Spawner<>();
        Spawner<? super Zombie> destination = generalSpawner;
        destination.setEntity(new Zombie());
        System.out.println("Set template successfully.");
        Object o = destination.spawn();
    }
    private static void step4_PECS() {
        Spawner<Zombie> zSource = new Spawner<>();
        zSource.setEntity(new Zombie());
        Spawner<Entity> eDest = new Spawner<>();
        transferMob(zSource, eDest);
    }
    public static void transferMob(Spawner<? extends Entity> producer,
                                   Spawner<? super Entity> consumer) {
        Entity e = producer.spawn();
        consumer.setEntity(e);
        System.out.println("Transferred: " + e);
    }
}
class RawSpawner {
    private Object entity;
    public void setEntity(Object e) { this.entity = e; }
    public Object spawn() { return entity; }
}
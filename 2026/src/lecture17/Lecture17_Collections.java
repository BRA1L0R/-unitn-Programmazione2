package lecture17;
import java.util.*;
public class Lecture17_Collections {
    public static void main(String[] args) {
        System.out.println("=== LECTURE 17: COLLECTIONS FRAMEWORK ===\n");
        step1_theBigThree();
        step2_implementations();
        step3_queuesAndDeques();
        step4_codingToInterface();
    }
    private static void step1_theBigThree() {
        System.out.println("=== 1. The Big Three ===");
        List<String> hotbar = new ArrayList<>();
        hotbar.add("Sword");
        hotbar.add("Dirt");
        hotbar.add("Dirt");
        System.out.println("List: " + hotbar);
        Set<String> biomes = new HashSet<>();
        biomes.add("Forest");
        biomes.add("Desert");
        biomes.add("Forest");
        System.out.println("Set: " + biomes);
        Map<String, Integer> durabilityRegistry = new HashMap<>();
        durabilityRegistry.put("Wood_Pickaxe", 59);
        durabilityRegistry.put("Iron_Pickaxe", 250);
        System.out.println("Map Value: " + durabilityRegistry.get("Iron_Pickaxe"));
    }
    private static void step2_implementations() {
        List<String> fastRead  = new ArrayList<>();
        List<String> fastWrite = new LinkedList<>();
        Map<String, Integer> registry= new HashMap<>();
        Map<String, Integer> reg_sort= new TreeMap<>();
    }
    private static void step3_queuesAndDeques() {
        System.out.println("\n=== 4. Queues (FIFO) ===");
        Queue<String> commandQueue = new ArrayDeque<>();
        commandQueue.add("/gamemode creative");
        commandQueue.add("/kill @e[type=bat]");
        commandQueue.add("/say Hello");
        while (!commandQueue.isEmpty()) {
            String cmd = commandQueue.poll();
            System.out.println(" Executing: " + cmd);
        }
    }
    private static void step4_codingToInterface() {
        System.out.println("\n=== 3. Weakest Possible Type ===");
        ArrayList<String> myItems = new ArrayList<>();
        myItems.add("Apple");
        printInventory(myItems);
        countItems(myItems);
    }
    public static void printBad(ArrayList<String> items) {
        for (String s : items) System.out.println(s);
    }
    public static void printInventory(List<String> items) {
        System.out.println("Item 1: " + items.get(0));
    }
    public static void countItems(Collection<String> items) {
        System.out.println("Count: " + items.size());
    }
}
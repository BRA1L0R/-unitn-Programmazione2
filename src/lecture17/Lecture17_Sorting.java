package lecture17;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Lecture17_Sorting {
    public static void main(String[] args) {
        step1_comparable();
        step2_comparator();
        step3_modernSorting();
    }
    private static void step1_comparable() {
        System.out.println("=== 1. Comparable (Natural Order: By Value) ===");
        List<LootItem> inventory = new ArrayList<>();
        inventory.add(new LootItem("Stick", 1));
        inventory.add(new LootItem("Diamond", 100));
        inventory.add(new LootItem("Iron Ingot", 50));
        Collections.sort(inventory);
        for (LootItem item : inventory) {
            System.out.println(item);
        }
    }
    private static void step2_comparator() {
        System.out.println("\n=== 2. Comparator (Custom Order: By Name) ===");
        List<LootItem> inventory = new ArrayList<>();
        inventory.add(new LootItem("Stick", 1));
        inventory.add(new LootItem("Diamond", 100));
        inventory.add(new LootItem("Coal", 1));
        Comparator<LootItem> nameSorter = new NameSorter();
        inventory.sort(nameSorter);
        for (LootItem item : inventory) {
            System.out.println(item);
        }
    }
    private static void step3_modernSorting() {
        System.out.println("\n=== 3. Inline Comparators ===");
        List<LootItem> inventory = new ArrayList<>();
        inventory.add(new LootItem("Stick", 1));
        inventory.add(new LootItem("Coal", 1));
        inventory.add(new LootItem("Diamond", 100));
        inventory.sort(
                Comparator.comparingInt(LootItem::getValue)
                        .reversed()
                        .thenComparing(LootItem::getName)
        );
        for (LootItem item : inventory) {
            System.out.println(item);
        }
    }
}
class LootItem implements Comparable<LootItem> {
    String name;
    int goldValue;
    public LootItem(String name, int value) {
        this.name = name;
        this.goldValue = value;
    }
    public String getName() { return name; }
    public int getValue() { return goldValue; }
    @Override
    public int compareTo(LootItem other) {
        return other.goldValue - this.goldValue;
    }
    @Override
    public String toString() {
        return name + " (" + goldValue + "g)";
    }
}
class NameSorter implements Comparator<LootItem> {
    @Override
    public int compare(LootItem o1, LootItem o2) {
        return o1.name.compareTo(o2.name);
    }
}
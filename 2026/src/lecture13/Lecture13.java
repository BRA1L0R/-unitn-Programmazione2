package lecture13;
import java.io.IOException;
public class Lecture13 {
        private static void step1_whyExceptions() {
            System.out.println("=== 1. Why Exceptions? ===");
            CraftingTable table = new CraftingTable();
            try {
                table.craftAdvanced("Diamond_Sword");
            }
            catch (RecipeMissingException e) {
                System.out.println("Unknown Recipe: " + e.getMessage());
                System.out.println(">> Opening Recipe Book...");
            }
            catch (InventoryFullException e) {
                System.out.println("Inventory Full: " + e.getMessage());
                System.out.println(">> Please clear a slot.");
            }
            catch (Exception e) {
                System.out.println("Critical Error: " + e.getMessage());
            }
        }
        private static void step2_checkedVsUnchecked() {
            System.out.println("\n=== 2. Checked vs Unchecked ===");
            try {
                savePlayerData();
            } catch (IOException e) {
                System.out.println("Could not save game. Retrying...");
            }
        }
        private static void step3_badCatching() {
            try {
                riskyMethod();
            }
            catch (Exception e) {
            }
        }
    private static void step5_exceptionHierarchy() {
        System.out.println("=== 5. Exception Hierarchy ===");
        CraftingTable table = new CraftingTable();
        try {
            table.craftAdvanced("UnknownSword");
        }
        catch (RecipeMissingException e) {
            System.out.println("[Specific Fix] Opening Tutorial: " + e.getMessage());
        }
        catch (CraftingException e) {
            System.out.println("[General Crafting Fix] Returning items to player. Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Something terrible happened.");
        }
    }
        private static void getInventorySlot(int i) {
            throw new IndexOutOfBoundsException();
        }
        private static void savePlayerData() throws IOException {
            throw new IOException("Disk Full");
        }
        private static void riskyMethod() {
            throw new NullPointerException();
        }
    }
class CraftingTable {
    public void craftAdvanced(String item) throws CraftingException {
        if (item.equals("UnknownThing")) {
            throw new RecipeMissingException("What is a " + item + "?");
        }
        boolean hasSpace = false;
        if (!hasSpace) {
            throw new InventoryFullException("No empty slots available.");
        }
    }
    public int craft_legacy(String item) {
        if (item.equals("Bedrock")) return -1;
        return 0;
    }
}
class CraftingException extends Exception {
    public CraftingException(String msg) { super(msg); }
}
class RecipeMissingException extends CraftingException {
    public RecipeMissingException(String msg) { super(msg); }
}
class InventoryFullException extends CraftingException {
    public InventoryFullException(String msg) { super(msg); }
}
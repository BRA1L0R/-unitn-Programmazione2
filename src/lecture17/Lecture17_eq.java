package lecture17;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Lecture17_eq {
    public static void main(String[] args) {
        step1_identityVsEquality();
        step2_equalsOnly();
        step3_hashSetFailure();
        step4_theSolution();
    }
    private static void step1_identityVsEquality() {
        System.out.println("=== 1. Identity vs Equality ===");
        BlockPos posA = new BlockPos(10, 64, 10);
        BlockPos posB = new BlockPos(10, 64, 10);
        System.out.println("posA == posB: " + (posA == posB));
        System.out.println("posA.equals(posB): " + posA.equals(posB));
    }
    private static void step2_equalsOnly() {
        System.out.println("\n=== 2. The Half Fix (Only Equals) ===");
        PosWithEquals p1 = new PosWithEquals(10, 64, 10);
        PosWithEquals p2 = new PosWithEquals(10, 64, 10);
        System.out.println("p1.equals(p2): " + p1.equals(p2));
    }
    private static void step3_hashSetFailure() {
        System.out.println("\n=== 3. The Trap (HashSet) ===");
        Set<PosWithEquals> brokenSet = new HashSet<>();
        PosWithEquals p1 = new PosWithEquals(10, 64, 10);
        PosWithEquals p2 = new PosWithEquals(10, 64, 10);
        brokenSet.add(p1);
        brokenSet.add(p2);
        System.out.println("Set Size: " + brokenSet.size());
    }
    private static void step4_theSolution() {
        System.out.println("\n=== 4. The Solution (SmartPos) ===");
        Set<SmartPos> safeSet = new HashSet<>();
        SmartPos p1 = new SmartPos(10, 64, 10);
        SmartPos p2 = new SmartPos(10, 64, 10);
        safeSet.add(p1);
        safeSet.add(p2);
        System.out.println("Set Size: " + safeSet.size());
        SmartPos p3 = new SmartPos(10, 64, 10);
        boolean found = safeSet.contains(p3);
        System.out.println("Contains p3? " + found);
    }
}
class BlockPos {
    int x, y, z;
    public BlockPos(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class PosWithEquals {
    int x, y, z;
    public PosWithEquals(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosWithEquals that = (PosWithEquals) o;
        return x == that.x && y == that.y && z == that.z;
    }
}
class SmartPos {
    final int x, y, z;
    public SmartPos(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartPos that = (SmartPos) o;
        return x == that.x && y == that.y && z == that.z;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
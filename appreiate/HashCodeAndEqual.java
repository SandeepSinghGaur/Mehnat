package appreiate;

import java.util.HashSet;

public class HashCodeAndEqual {
    public static void main(String[] args) {
        HashSet<Country> hs = new HashSet<>();
        Country c1 = new Country("India","IN");
        hs.add(c1);
        System.out.println(STR."C1 HashCode \{c1.hashCode()}"); // c1 store x1 hashcode
        Country c2 = new Country("India","IN");
        System.out.println(STR."C2 HashCode \{c2.hashCode()}");
        System.out.println(STR."C1 Memory Address: \{System.identityHashCode(c1)}");
        System.out.println(STR."C2 Memory Address: \{System.identityHashCode(c2)}");
        System.out.println(hs.contains(c2));

        Country c3 = new Country();
        Country c4 = new Country();
        System.out.println(c3.equals(c4));
    }
}

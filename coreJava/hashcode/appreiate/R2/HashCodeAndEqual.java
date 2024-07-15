package coreJava.hashcode.appreiate.R2;

import java.util.HashSet;

public class HashCodeAndEqual {
    public static void main(String[] args) {
        HashSet<Country> hs = new HashSet<>();
        Country c1 = new Country("India","IN");
        hs.add(c1);
        Country c2 = new Country("India","IN");
        System.out.println(hs.contains(c2));
    }
}

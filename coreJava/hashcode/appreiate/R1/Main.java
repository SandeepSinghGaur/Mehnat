package coreJava.hashcode.appreiate.R1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("ZM","Zimbab"));
        countryList.add(new Country("AG","Afganistan"));
        countryList.add(new Country("IN","India"));
        countryList.add(new Country("IN","India"));
        countryList.stream().filter(e->e.getCountryName().equals("India")).forEach(e->{
          System.out.println(e.getCountryName());
      });

        countryList.stream().filter(e->e.getCountryName()!="India").sorted(Comparator.comparing(Country::getCountryName)).forEach(e -> System.out.println(e.getCountryName()));
    }
}

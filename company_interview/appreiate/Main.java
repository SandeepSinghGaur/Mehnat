package company_interview.appreiate;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("ZM","Zimbab"));
        countryList.add(new Country("AG","Afganistan"));
        countryList.add(new Country("IN","India"));
        Collections.sort(countryList,Comparator.comparing(Country::getCountryName));
        int index = -1;
        for (int i = 0; i < countryList.size(); i++) {
            if ("India".equals(countryList.get(i).getCountryName())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Country india = countryList.remove(index);
            countryList.add(0, india);
        }

        for (Country country : countryList) {
            System.out.println(country.getCountryName());
        }

    }
}

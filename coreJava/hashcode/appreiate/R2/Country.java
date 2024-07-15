package coreJava.hashcode.appreiate.R2;

import java.util.Objects;

public class Country {
    private String countryCode;
    private String countryName;


    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
    public Country(){

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return (Objects.equals(countryCode, country.countryCode) && Objects.equals(countryName, country.countryName)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode,countryName);
    }
}

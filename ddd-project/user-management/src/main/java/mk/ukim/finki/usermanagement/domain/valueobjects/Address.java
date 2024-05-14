package mk.ukim.finki.usermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address() {

    }

    public boolean isValid() {
        if (street == null || street.isEmpty() ||
                city == null || city.isEmpty() ||
                postalCode == null || postalCode.isEmpty() ||
                country == null || country.isEmpty()) {
            return false;
        }

        if (!postalCode.matches("\\d{4}")) {
            return false;
        }

        if (country.length() < 2) {
            return false;
        }
        return true;
    }
}

package mk.ukim.finki.usermanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.financial.Money;
import mk.ukim.finki.usermanagement.domain.valueobjects.Address;

@Entity
@Table(name = "ticket_user")
@Getter
public class User extends AbstractEntity<UserId> {

    private String name;
    private String email;
    private String password;
    private Address address;
    private Long phone;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User build(String name, String email, String password, Address address, Long phone) {
        User u = new User();
        u.name = name;
        u.email = email;
        u.password = password;
        u.address = address;
        u.phone = phone;
        return u;
    }

    public void updateDetails(String newName, String newEmail, String newPassword, Address newAddress, Long newPhone){
        this.name = newName;
        this.email = newEmail;
        this.password = newPassword;
        this.address = newAddress;
        this.phone = newPhone;
    }
}

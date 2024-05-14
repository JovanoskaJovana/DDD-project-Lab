package mk.ukim.finki.usermanagement.service;

import mk.ukim.finki.usermanagement.domain.models.User;
import mk.ukim.finki.usermanagement.domain.valueobjects.Address;

import java.util.List;

public interface UserService {
    User createUser(String name, String email, String password, Address address, Long phone);
    User updateUser(String userId, String name, String email, String password, Address address, Long phone);
    List<User> findAllUsers();
    User findUserById(String userId);
    void deleteUser(String userId);
}

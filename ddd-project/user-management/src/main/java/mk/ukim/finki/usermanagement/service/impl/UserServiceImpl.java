package mk.ukim.finki.usermanagement.service.impl;

import mk.ukim.finki.usermanagement.domain.models.User;
import mk.ukim.finki.usermanagement.domain.models.UserId;
import mk.ukim.finki.usermanagement.domain.repository.UserRepository;
import mk.ukim.finki.usermanagement.domain.valueobjects.Address;
import mk.ukim.finki.usermanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String email, String password, Address address, Long phone) {
        User user = User.build(name, email, password, address, phone);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String userId, String name, String email, String password, Address address, Long phone) {
        User user = userRepository.findById(new UserId(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        user.updateDetails(name, email, password, address, phone);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String userId) {
        return userRepository.findById(new UserId(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(new UserId(userId));
    }
}

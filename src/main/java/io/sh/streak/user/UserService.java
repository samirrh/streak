package io.sh.streak.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userCheck = userRepository.findUserByEmail(user.getEmail());
        if (userCheck.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalStateException("User with id: " + userId + " not found");
        }
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id: " + userId + " not found"));
        if (name != null && name.length() > 0 && name != user.getName()) {
            user.setName(name);
        }
        if (email != null && email.length() > 0 && email != user.getEmail()) {
            Optional<User> userByEmail = userRepository.findUserByEmail(email);
            if (userByEmail.isPresent()) {
                throw new IllegalStateException("User with email: " + email + " already taken");
            }
            user.setEmail(email);
        }
    }

    @Transactional
    public int updateStreak(Long userId, Boolean increaseStreak) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id: " + userId + " not found"));
        if (increaseStreak) {
            user.setStreak(user.getStreak() + 1);
        } else {
            user.setStreak(user.getStreak() - 1);
        }
        return user.getStreak();
        // add handling to stop negative streak and a reset streak
        // as well as date checking for update
    }

}

package com.example.springtest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EuserService {
    @Autowired
    private EuserRepository userRepository;
    public List<Euser> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<Euser> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public Euser saveUser(Euser user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
package com.project.employee_records.service;

import com.project.employee_records.model.User;
import com.project.employee_records.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(Integer idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User setUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer idUser) {
        userRepository.deleteById(idUser);
    }
}

package com.rolemberg.eventostech.Services.Users;

import com.rolemberg.eventostech.Domain.Users.User;
import com.rolemberg.eventostech.Domain.Users.UserRegisterDTO;
import com.rolemberg.eventostech.Enums.Role;
import com.rolemberg.eventostech.Repository.Users.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = this.usersRepo.findAll(pageable);
        return userPage.toList();
    }

    public User register(UserRegisterDTO data) {
        String password = passwordEncoder.encode(data.password());
        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(password);
        user.setRole(Role.USER);
        usersRepo.save(user);
        return user;
    }

    public User delete(UUID id) {
        User user = usersRepo.findById(id).orElseThrow();
        usersRepo.deleteById(id);
        return user;
    }
}

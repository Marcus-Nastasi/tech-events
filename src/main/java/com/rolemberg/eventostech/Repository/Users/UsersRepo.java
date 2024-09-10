package com.rolemberg.eventostech.Repository.Users;

import com.rolemberg.eventostech.Domain.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<User, UUID> {

    UserDetails findByEmail(String email);
}

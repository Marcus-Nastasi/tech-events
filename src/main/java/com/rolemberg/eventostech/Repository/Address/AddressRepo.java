package com.rolemberg.eventostech.Repository.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {
}

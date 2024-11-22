package com.rolemberg.eventostech.resource.repository.address;

import com.rolemberg.eventostech.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {
}

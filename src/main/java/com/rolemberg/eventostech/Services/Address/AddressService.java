package com.rolemberg.eventostech.Services.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Repository.Address.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public List<Address> get() {
        return addressRepo.findAll();
    }
}

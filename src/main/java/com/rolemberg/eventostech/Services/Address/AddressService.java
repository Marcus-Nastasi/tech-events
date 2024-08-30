package com.rolemberg.eventostech.Services.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Domain.Address.AddressRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Repository.Address.AddressRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private EventRepo eventRepo;

    public List<Address> get() {
        return addressRepo.findAll();
    }

    public Address create(EventRegisterDTO data, Event e) {
        Address a = new Address();
        a.setCity(data.city());
        a.setUf(data.state());
        a.setEvent(e);
        addressRepo.save(a);
        return a;
    }
}

package com.rolemberg.eventostech.Services.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Domain.Address.AddressEResponseDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Repository.Address.AddressRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private EventRepo eventRepo;

    public List<AddressEResponseDTO> get() {
        List<Address> addresses = addressRepo.findAll();
        List<AddressEResponseDTO> addressEResponseDTOS = new ArrayList<>();
        addresses.forEach(a -> {
            EventCleanResponseDTO eventCleanResponseDTO = new EventCleanResponseDTO(
                a.getEvent().getId(), a.getEvent().getTitle(), a.getEvent().getDescription(),
                a.getEvent().getDate(), a.getEvent().getRemote(), a.getEvent().getImage_url(),
                a.getEvent().getEvent_url()
            );
            addressEResponseDTOS
                .add(new AddressEResponseDTO(a.getId(), a.getCity(), a.getUf(), eventCleanResponseDTO));
        });
        return addressEResponseDTOS;
    }

    public Address create(EventRegisterDTO data, Event e) {
        Address a = new Address();
        a.setCity(data.city());
        a.setUf(data.state());
        if (e == null) return null;
        a.setEvent(e);
        addressRepo.save(a);
        return a;
    }
}

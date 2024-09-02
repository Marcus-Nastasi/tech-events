package com.rolemberg.eventostech.Services.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Domain.Address.AddressEventResponseDTO;
import com.rolemberg.eventostech.Domain.Address.AddressUpdateDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Repository.Address.AddressRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private EventService eventService;

    public List<AddressEventResponseDTO> get() {
        List<Address> addresses = addressRepo.findAll();
        List<AddressEventResponseDTO> addressEventResponseDTOS = new ArrayList<>();
        addresses.forEach(a -> {
            addressEventResponseDTOS
                .add(new AddressEventResponseDTO(
                    a.getId(),
                    a.getCity(),
                    a.getUf(),
                    eventService.mapToEventCleanResponseDTO(a.getEvent()))
                );
        });
        return addressEventResponseDTOS;
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

    public AddressEventResponseDTO update(UUID id, AddressUpdateDTO data) {
        Address a = addressRepo
            .findById(id)
            .orElseThrow(IllegalArgumentException::new);
        a.setCity(data.city());
        a.setUf(a.getUf());
        addressRepo.save(a);
        EventCleanResponseDTO eventCleanResponseDTO = eventService
            .mapToEventCleanResponseDTO(a.getEvent());
        return mapToAddressEventResponseDTO(a, eventCleanResponseDTO);
    }

    public AddressEventResponseDTO delete(UUID id) {
        Address a = addressRepo
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);
        EventCleanResponseDTO eventCleanResponseDTO = eventService
            .mapToEventCleanResponseDTO(a.getEvent());
        addressRepo.deleteById(id);
        return mapToAddressEventResponseDTO(a, eventCleanResponseDTO);
    }

    private AddressEventResponseDTO mapToAddressEventResponseDTO(
            Address address,
            EventCleanResponseDTO eventCleanResponseDTO
    ) {
        return new AddressEventResponseDTO(
            address.getId(),
            address.getCity(),
            address.getUf(),
            eventCleanResponseDTO
        );
    }
}

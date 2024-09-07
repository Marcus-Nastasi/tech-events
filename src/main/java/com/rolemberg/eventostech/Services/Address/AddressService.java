package com.rolemberg.eventostech.Services.Address;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Domain.Address.AddressEventResponseDTO;
import com.rolemberg.eventostech.Domain.Address.AddressUpdateDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Handlers.AppError;
import com.rolemberg.eventostech.Repository.Address.AddressRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public List<AddressEventResponseDTO> get(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Address> addresses = addressRepo.findAll(pageable);
        return addresses.map(this::mapToAddressEventResponseDTO).toList();
    }

    public Address createFromEvent(EventRegisterDTO data, Event e) {
        Address a = new Address();
        a.setCity(data.city());
        a.setUf(data.state());
        if (e == null) return null;
        a.setEvent(e);
        addressRepo.save(a);
        return a;
    }

    public AddressEventResponseDTO create(UUID event_id, AddressUpdateDTO data) {
        Event event = eventRepo
            .findById(event_id)
            .orElseThrow(() -> new AppError("Error finding associated event while creating the address"));
        Address a = new Address();
        a.setCity(data.city());
        a.setUf(data.uf());
        a.setEvent(event);
        addressRepo.save(a);
        event.getAddresses().add(a);
        eventRepo.save(event);
        return mapToAddressEventResponseDTO(a);
    }

    public AddressEventResponseDTO update(UUID id, AddressUpdateDTO data) {
        Address a = addressRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Error finding address while trying to update"));
        a.setCity(data.city());
        a.setUf(data.uf());
        addressRepo.save(a);
        EventCleanResponseDTO eventCleanResponseDTO = eventService
            .mapToEventCleanResponseDTO(a.getEvent());
        return mapToAddressEventResponseDTO(a);
    }

    public AddressEventResponseDTO delete(UUID id) {
        Address a = addressRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Error finding address while trying to delete"));
        EventCleanResponseDTO eventCleanResponseDTO = eventService
            .mapToEventCleanResponseDTO(a.getEvent());
        addressRepo.deleteById(id);
        return mapToAddressEventResponseDTO(a);
    }

    private AddressEventResponseDTO mapToAddressEventResponseDTO(Address address) {
        return new AddressEventResponseDTO(
            address.getId(),
            address.getCity(),
            address.getUf(),
            eventService.mapToEventCleanResponseDTO(address.getEvent())
        );
    }
}

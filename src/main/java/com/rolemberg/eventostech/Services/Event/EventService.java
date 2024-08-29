package com.rolemberg.eventostech.Services.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event createEvent(EventRegisterDTO data) {
        Event e = new Event();
        e.setId(UUID.randomUUID());
        e.setTitle(data.title());
        e.setDescription(data.description());
        e.setImage_url(null);
        e.setEvent_url(data.event_url());
        e.setRemote(data.remote());
        e.setDate(data.date());
        eventRepo.save(e);
        return e;
    }

    private String uploadToS3(MultipartFile image) {
        return "";
    }
}

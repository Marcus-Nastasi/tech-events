package com.rolemberg.eventostech;

import com.rolemberg.eventostech.domain.event.Event;
import com.rolemberg.eventostech.resource.repository.event.EventRepo;
import com.rolemberg.eventostech.resource.services.event.EventService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.UUID.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EventServiceTests {

    @Mock
    private EventRepo eventRepo;
    @InjectMocks
    private EventService eventService;

    Event event1 = new Event(randomUUID(), "title 1", "description 1", "img 1", "event url 1", true, LocalDate.now(), List.of(), List.of());
    Event event2 = new Event(randomUUID(), "title 2", "description 2", "img 2", "event url 2", true, LocalDate.now(), List.of(), List.of());

    @Test
    void getTest() {
        when(eventRepo.findAll(any(Pageable.class))).thenReturn(Page.empty());
        assertEquals(List.of(), eventService.getEvents(0, 5));
        assertDoesNotThrow(() -> {
            eventService.getEvents(0, 10);
        });
    }
}

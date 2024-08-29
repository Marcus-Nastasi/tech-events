package com.rolemberg.eventostech.Repository.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepo extends JpaRepository<Event, UUID> {
}

package com.rolemberg.eventostech.resource.repository.event;

import com.rolemberg.eventostech.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface EventRepo extends JpaRepository<Event, UUID> {

    @Query(nativeQuery = true, value = "SELECT e.* FROM event e " +
            "LEFT JOIN address a ON a.event_id = e.id " +
            "WHERE (:title IS NULL OR e.title LIKE CONCAT('%', :title, '%')) " +
            "AND (:city IS NULL OR a.city LIKE CONCAT('%', :city, '%')) " +
            "AND (:uf IS NULL OR a.uf LIKE CONCAT('%', :uf, '%')) " +
            "AND (e.date >= :start_date) " +
            "AND (e.date <= :end_date) " +
            "ORDER BY e.date ASC;")
    Page<Event> findFilteredEvents(
        @Param("title") String title,
        @Param("city") String city,
        @Param("uf") String uf,
        @Param("start_date") LocalDate start_date,
        @Param("end_date") LocalDate end_date,
        Pageable pageable
    );
}

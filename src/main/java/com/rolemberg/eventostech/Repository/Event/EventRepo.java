package com.rolemberg.eventostech.Repository.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public interface EventRepo extends JpaRepository<Event, UUID> {

    @Query(nativeQuery = true, value = "SELECT e.* FROM event e " +
            "LEFT JOIN address a ON a.event_id = e.id " +
            "WHERE (:title IS NULL OR e.title LIKE CONCAT('%', :title, '%')) " +
            "AND (:city IS NULL OR a.city LIKE CONCAT('%', :city, '%')) " +
            "AND (:uf IS NULL OR a.uf LIKE CONCAT('%', :uf, '%')) " +
            "AND (e.date > :start_date) " +
            "AND (e.date < :end_date) " +
            "ORDER BY e.date ASC;")
    Page<Event> findFilteredEvents(
        //@Param("current_date") LocalDate current_date,
        @Param("title") String title,
        @Param("city") String city,
        @Param("uf") String uf,
        @Param("start_date") LocalDate start_date,
        @Param("end_date") LocalDate end_date,
        Pageable pageable
    );
}

/*
"SELECT e.* FROM event e " +
            "LEFT JOIN address a ON a.event_id = e.id " +
            "WHERE (:title IS NULL OR e.title LIKE CONCAT('%', :title, '%')) " +
            "AND (:city IS NULL OR a.city LIKE CONCAT('%', :city, '%')) " +
            "AND (:uf IS NULL OR a.uf LIKE CONCAT('%', :uf, '%')) " +
            "AND (:start_date IS NULL OR e.date > :start_date) " +
            "AND (:end_date IS NULL OR e.date < :end_date) " +
            "ORDER BY e.date ASC;"
* */

/*
*
* SELECT e.* FROM Event e " +
            "WHERE (e.date >= :start_date) " +
            "AND (e.date <= :end_date)
* */
package com.rolemberg.eventostech.Domain.Address;

import com.rolemberg.eventostech.Domain.Event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "address")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String city;
    private String uf;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}

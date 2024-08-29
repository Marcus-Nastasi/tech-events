package com.rolemberg.eventostech.Domain.Coupon;

import com.rolemberg.eventostech.Domain.Event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "coupon")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String code;
    private Double discount;
    private LocalDate valid;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}

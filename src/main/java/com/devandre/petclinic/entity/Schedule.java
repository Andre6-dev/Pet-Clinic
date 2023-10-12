package com.devandre.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * andre on 6/10/2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {

    @Id
    private Long scheduleId;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Integer allDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinarian_id", referencedColumnName = "veterinarian_id",nullable = false)
    @ToString.Exclude
    private Veterinarian veterinarian;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(scheduleId, schedule.scheduleId) && Objects.equals(timeStart, schedule.timeStart) && Objects.equals(timeEnd, schedule.timeEnd) && Objects.equals(allDay, schedule.allDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, timeStart, timeEnd, allDay);
    }
}

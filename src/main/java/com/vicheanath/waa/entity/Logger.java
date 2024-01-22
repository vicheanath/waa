package com.vicheanath.waa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;
    @CreationTimestamp
    private LocalDate date;
    @CreationTimestamp
    private LocalTime time;
    private String principle;
    private String operation;

}

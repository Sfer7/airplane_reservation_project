package com.project.airplane_reservation.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(length = 15)
    private String userId;
    @NotNull
    @Column(length = 10)
    private String name;
    @NotNull
    @Column(length = 15)
    private String phoneNum;
    private String email;
    private LocalDate regDate;
    private long mileage;
}

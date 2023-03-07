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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(length = 20)
    private String companyName;
    @NotNull
    private String companyNum;
    @NotNull
    @Column(length = 15)
    private String phoneNum;
    private String webPage;
    private LocalDate regDate;
    private long totalRegItems;
    private long totalSales;
}

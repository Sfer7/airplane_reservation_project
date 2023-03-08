package com.project.airplane_reservation.company.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company implements CompanyState{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(length = 20)
    private String companyName;
    @NotNull
    private String companyNum;
    @NotNull
    private String password;
    @NotNull
    @Column(length = 15)
    private String phoneNum;
    private String webPage;
    @NotNull
    private String address;
    private LocalDate regDate;
    private long totalRegItems;
    private long totalSales;
    @NotNull
    private String state;
}

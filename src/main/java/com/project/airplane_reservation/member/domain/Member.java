package com.project.airplane_reservation.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements MemberState {
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
    private String password;
    @NotNull
    @Column(length = 15)
    private String phoneNum;
    private String email;
    private LocalDate regDate;
    @NotNull
    private String state;
    private long mileage;
    private String emailAuthKey;
}

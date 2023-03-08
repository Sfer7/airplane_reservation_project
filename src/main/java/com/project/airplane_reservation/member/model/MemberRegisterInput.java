package com.project.airplane_reservation.member.model;

import lombok.Data;

@Data
public class MemberRegisterInput {
    private String userId;
    private String name;
    private String password;
    private String phoneNum;
    private String email;
}

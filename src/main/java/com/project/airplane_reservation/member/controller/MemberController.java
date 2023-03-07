package com.project.airplane_reservation.member.controller;

import com.project.airplane_reservation.member.repository.MemberRepository;
import com.project.airplane_reservation.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
}

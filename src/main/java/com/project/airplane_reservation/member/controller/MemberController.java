package com.project.airplane_reservation.member.controller;

import com.project.airplane_reservation.member.model.MemberRegisterInput;
import com.project.airplane_reservation.member.repository.MemberRepository;
import com.project.airplane_reservation.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/member/register")
    public void registerMember(@RequestBody @Valid MemberRegisterInput parameter) {
        memberService.register(parameter);
    }

    @GetMapping("/member/email-auth")
    public void emailAuth(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("id");
        memberService.emailAuth(uuid);
    }
}

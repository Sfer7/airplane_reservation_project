package com.project.airplane_reservation.member.service;

import com.project.airplane_reservation.member.domain.Member;
import com.project.airplane_reservation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public boolean register(String userId, String email) {
        Optional<Member> optionalMember= memberRepository.findAllByUserIdOrEmail(userId, email);
        if(optionalMember.isPresent()) {
            if(userId.equals(optionalMember.get().getUserId()))
                System.out.println("이미 사용중인 아이디입니다.");
            if(email.equals(optionalMember.get().getEmail()))
                System.out.println("이미 사용중인 이메일입니다.");
            return false;
        }
        return true;
    }

}

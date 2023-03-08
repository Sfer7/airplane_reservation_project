package com.project.airplane_reservation.member.service;

import com.project.airplane_reservation.components.MailComponents;
import com.project.airplane_reservation.member.domain.Member;
import com.project.airplane_reservation.member.model.MemberRegisterInput;
import com.project.airplane_reservation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static com.project.airplane_reservation.member.domain.MemberState.MEMBER_STATE_CONFIRM;
import static com.project.airplane_reservation.member.domain.MemberState.MEMBER_STATE_REQUIRE;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;
    public boolean register(MemberRegisterInput parameter) {
        Optional<Member> optionalMember= memberRepository.findByUserIdOrEmail(parameter.getUserId(), parameter.getEmail());
        if(optionalMember.isPresent()) {
            System.out.println("아이디 또는 이메일을 이미 사용중입니다.");
            return false;
        }

        String email = parameter.getEmail();
        String uuid = UUID.randomUUID().toString();

        Member curMember = Member.builder()
                .userId(parameter.getUserId())
                .name(parameter.getName())
                .password(parameter.getPassword())
                .phoneNum(parameter.getPhoneNum())
                .email(email)
                .regDate(LocalDate.now())
                .state(MEMBER_STATE_REQUIRE)
                .mileage(0)
                .emailAuthKey(uuid)
                .build();
        memberRepository.save(curMember);

        String subject = "항공기 예약 서비스 페이지 가입 인증 메일";
        String message = "<h1>항공기 예약 서비스 가입 인증 메일</h1>" +
                         "<br><p>아래 링크를 클릭하여 인증을 완료해 주세요.</p>" +
                         "<div><a target='_blank' href='http://localhost:8080/member/email-auth?id=" +
                         uuid + "'> 인증 확인 </a></div>";
        mailComponents.sendMail(email, subject, message);

        return true;
    }

    public boolean emailAuth(String uuid) {
        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
        if(optionalMember.isEmpty()) {
            System.out.println("존재하지 않는 인증 키 입니다.");
            return false;
        }

        Member curMember = optionalMember.get();
        if(!curMember.getState().equals(MEMBER_STATE_REQUIRE)) {
            System.out.println("인증이 필요하지 않은 이메일입니다.");
            return false;
        }
        curMember.setState(MEMBER_STATE_CONFIRM);
        memberRepository.save(curMember);

        return true;
    }

}

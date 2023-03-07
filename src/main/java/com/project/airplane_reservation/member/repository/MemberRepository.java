package com.project.airplane_reservation.member.repository;

import com.project.airplane_reservation.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository <Member, String> {
    Optional<Member> findAllByUserIdOrEmail(String userId, String email);
}

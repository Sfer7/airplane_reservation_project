package com.project.airplane_reservation.repository;

import com.project.airplane_reservation.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository <Member, String> {
    Optional<Member> findByUserIdOrEmail(String userId, String email);
}

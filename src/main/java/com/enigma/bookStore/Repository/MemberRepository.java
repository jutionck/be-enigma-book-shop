package com.enigma.bookStore.Repository;

import com.enigma.bookStore.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByEmailEqualsAndPasswordEquals(String email, String password);
}

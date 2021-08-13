package com.enigma.bookStore.Repository;

import com.enigma.bookStore.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByEmailEqualsAndPasswordEquals(String email, String password);

    @Modifying
    @Query("UPDATE Member m SET m.status = 1 WHERE  c.id = :id")
    void deleteMember(@Param("id")Integer id);
}

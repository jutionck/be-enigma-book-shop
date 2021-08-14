package com.enigma.bookStore.Repository;

import com.enigma.bookStore.Entity.MemberhasBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<MemberhasBooks, Integer> {


}

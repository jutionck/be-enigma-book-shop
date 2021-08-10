package com.enigma.bookStore.Repository;

import com.enigma.bookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findBookByTitle(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Book b WHERE b.id = :id")
    public Book removeBook(@Param("id")Integer id);
}

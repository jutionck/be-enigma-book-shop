package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Repository.MemberRepository;
import com.enigma.bookStore.dto.RequestSignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository repository;


    @Override
    public Member signUp(Member member) {
        return repository.save(member);
    }

    @Override
    public Member signIn(String email, String password) throws FileNotFoundException {
        Member searchEmail = repository.findByEmailEqualsAndPasswordEquals(email, password);
        if (searchEmail!=null){
            return searchEmail;
        } else {
            throw new FileNotFoundException("Account not found");
        }
    }

    @Override
    public List<Member> getAllMember() {
        return repository.findAll();
    }

    @Override
    public Member deleteMember(Integer id) {
        Member member = repository.findById(id).get();
        member.setStatus(false);
        return member;
    }


}

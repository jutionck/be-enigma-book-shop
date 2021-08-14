package com.enigma.bookStore.Service;

import com.enigma.bookStore.Entity.Member;
//import com.enigma.bookStore.dto.RequestSignIn;

import java.io.FileNotFoundException;
import java.util.List;

public interface MemberService {

    public Member signUp(Member member);
    public Member signIn(String email, String password) throws FileNotFoundException;
    public List<Member> getAllMember();
    public void deleteMember(Integer id, Integer status);
}

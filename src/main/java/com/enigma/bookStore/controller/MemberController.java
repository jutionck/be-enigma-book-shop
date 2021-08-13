package com.enigma.bookStore.controller;

import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService service;

    @PostMapping
    public Member signUp(@RequestBody Member member){
        return service.signUp(member);
    }

    @GetMapping("/sign-in")
    public Member signIn(@RequestParam("email") String email, @RequestParam("password") String password) throws FileNotFoundException {
        return service.signIn(email, password);
    }

    @DeleteMapping("/{id}")
    public Member removeUser(@PathVariable Integer id) {
        return service.deleteMember(id);
    }

    @GetMapping
    public List<Member> getAllMember(){
        return service.getAllMember();
    }
}

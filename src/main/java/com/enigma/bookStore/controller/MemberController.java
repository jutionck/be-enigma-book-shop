package com.enigma.bookStore.controller;

import com.enigma.bookStore.Entity.Member;
import com.enigma.bookStore.Service.MemberService;
import com.enigma.bookStore.constant.ResponseMessage;
import com.enigma.bookStore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService service;

    @PostMapping
    public ResponseEntity<Response<Member>> signUp(@RequestBody Member member){
        Response<Member> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERTED, "member");
        response.setMessage(message);
        response.setData(service.signUp(member));

        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping("/sign-in")
    public ResponseEntity<Response<Member>> signIn(@RequestParam("email") String email, @RequestParam("password") String password) throws FileNotFoundException {
        Response<Member> response = new Response<>();
        String message = String.format(ResponseMessage.SUCCESS, "member");
        response.setMessage(message);
        response.setData(service.signIn(email, password));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @DeleteMapping("/{id}/{status}")
    public void removeUser(@PathVariable Integer id, @PathVariable Integer status) {
        service.deleteMember(id, status);
    }

    @GetMapping
    public List<Member> getAllMember(){
        return service.getAllMember();
    }
}

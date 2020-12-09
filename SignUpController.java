package com.signuppage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signuppage.dao.SignUpDao;
import com.signuppage.modal.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/demo")
public class SignUpController {
	@Autowired
	SignUpDao signupdao;
	
	
	@PostMapping("/signup")
	public User createEmployee( @RequestBody User user) {
		return signupdao.save(user);
	}
	
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Optional<User>> getEmployeeById(@PathVariable(value="id") Long id){
		
		Optional<User> user=signupdao.findOne(id);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
		
	}
	
	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public void demo(){
		
		System.out.println("HEY");
		
	}
	
	


}

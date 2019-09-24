package com.stockmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.dao.UserDAO;
import com.stockmarket.exception.RecordNotFoundException;
import com.stockmarket.model.User;
import com.stockmarket.model.UserBody;

@RestController
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

@Autowired
	UserDAO userDAO;	
	/* to get All User List */
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userDAO.getAllUsers();
 
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
	/* get a User by id */ 
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	User user = userDAO.getUserById(id);
 
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }
	
    /* create OrUpdateUser */
    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@Valid @RequestBody User user)
                                                    throws RecordNotFoundException {
    	User updated = userDAO.createOrUpdateUser(user);
        return new ResponseEntity<User>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	
    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	userDAO.deleteUserById(id);
        return HttpStatus.OK;
    }
	
    /* Get User by email and Password*/
	@PostMapping("/login")
	public ResponseEntity<User> getUserByEmailPass(@Valid @RequestBody UserBody userbody){
		//String password="";
		System.out.println("-------------------------");
		System.out.println(userbody.getEmail());
		System.out.println(userbody.getPassword());
		User user=userDAO.findByEmailPass(userbody.getEmail(),userbody.getPassword());
		
		if(user==null) {
			System.out.println("--------------------null-----");
			return ResponseEntity.notFound().build();
		}
		System.out.println("--------------return Resp----------");
		return ResponseEntity.ok().body(user);
		
	}













	
}

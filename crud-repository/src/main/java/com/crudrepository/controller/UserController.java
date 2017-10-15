package com.crudrepository.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crudrepository.DAO.implement.IUser;
import com.crudrepository.entity.model.User;

@Controller
public class UserController {

	 @Autowired
	 private IUser _user;
	 
	 @PostMapping(path="/user")
	 public ResponseEntity<User> createUser(@RequestBody User user){

			 this._user.save(user);
			 return new ResponseEntity<User>(user,HttpStatus.OK);
		
	 }
	 
	 @GetMapping(path="/user")
	 public ResponseEntity<List<User>> findAll(){
		 List<User> users = (List<User>) this._user.findAll();
		 return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	 }
	 
	 @GetMapping(path="/user/{id}")
	 public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
		 Optional<User> user =null;
		 if(this._user.existsById(id)) {
			 user = this._user.findById(id);
		 }
		 return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
	 }
	 @PutMapping(path="/user/{id}")
	 
	 public ResponseEntity<User> update(@PathVariable("id") Long id,@RequestBody User user){
		  if(this._user.existsById(id)){
			  this._user.save(user);
		  }
		  return new ResponseEntity<User>(user,HttpStatus.OK);
	 }
	 
	 @DeleteMapping(path="/user/{id}")
	 public ResponseEntity<String> delete(@PathVariable("id") Long id){
		 if(this._user.existsById(id)) {
			 this._user.deleteById(id);
		 }
		 return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
	 }
	 
	 
	 @GetMapping(path="/hello")
	 @ResponseBody
	 public String hello(){
	
		 return "hola mundo";
	 }
}

package org.sid.CompteRenduu.web;

import org.sid.compterendu.dao.CompteeRepository;
import org.sid.compterendu.entity.users.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compte")
public class CompteService {
	@Autowired
private CompteeRepository compterepository ;
	
@GetMapping(value="getAll")
public ResponseEntity<Object>  getUsers(){
		return new ResponseEntity<Object>(compterepository.findAll(),HttpStatus.OK);
	}
@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> save(@RequestBody Compte c){
		return new ResponseEntity<Object>(compterepository.save(c),HttpStatus.OK);	
	}
@DeleteMapping(value = "/delete/{id}")
public ResponseEntity<Object> supprimer(@PathVariable Long id){
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
@PutMapping(value = "/update/{id}")
public ResponseEntity<Object> save(@PathVariable Long ref,@RequestBody Compte c ){
		return new ResponseEntity<Object>(compterepository.save(c),HttpStatus.OK);
	}	
	
}

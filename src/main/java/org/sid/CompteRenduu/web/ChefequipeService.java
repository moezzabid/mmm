package org.sid.CompteRenduu.web;

import org.sid.compterendu.dao.Chef_equipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chef_equipe")
public class ChefequipeService {
@Autowired
 private Chef_equipeRepository chef_equiperepository ;
	@GetMapping(value="/getById/{id}")
	public ResponseEntity<Object> getByRef(@PathVariable Long id){
	return new ResponseEntity<Object>(chef_equiperepository.findById(id),HttpStatus.OK);
		}

}

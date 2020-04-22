package org.sid.compterendu.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.sid.compterendu.dao.ClientRepository;
import org.sid.compterendu.dao.ProjetRepository;
import org.sid.compterendu.dao.TravailRepository;
import org.sid.compterendu.entity.Projet;
import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.Travail;
import org.sid.compterendu.entity.users.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientService  implements Serializable {

@Autowired
private ClientRepository clientrepositroy ;
@Autowired
private ProjetRepository projetrepositroy ;
@Autowired
private TravailRepository travailrepositroy;

@GetMapping(value="getclient")
public ResponseEntity<Object>  getAll(){
		return new ResponseEntity<Object>(clientrepositroy.findAll(),HttpStatus.OK);
	}

@PostMapping(value="/addprojet")
public void addEmployee (@RequestBody Projet p ) {		

	projetrepositroy.save(p);

}
@DeleteMapping("/deletedemande/{id}")
public Map<String, Boolean> deletedemande(@PathVariable Long id)
		throws ResourceNotFoundException {
	Travail travail = travailrepositroy.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Pas de travail :: " + id));

	travailrepositroy.delete(travail);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Supprimer", Boolean.TRUE);
	return response;
}

@PostMapping(value="/addtravail")
public void addtravail (@RequestBody Travail t ) {		

	travailrepositroy.save(t);

}
@DeleteMapping("/deletetravail/{id}")
public Map<String, Boolean> deletetache(@PathVariable Long id)
		throws ResourceNotFoundException {
	Projet projet = projetrepositroy.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Pas de travail :: " + id));

	projetrepositroy.delete(projet);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Supprimer", Boolean.TRUE);
	return response;
}






}

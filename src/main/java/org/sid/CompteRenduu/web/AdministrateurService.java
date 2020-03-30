package org.sid.CompteRenduu.web;

import java.io.Serializable;
import java.util.Date;

import org.sid.compterendu.dao.AdministrateurRepository;
import org.sid.compterendu.dao.Chef_equipeRepository;
import org.sid.compterendu.dao.CompteeRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.sid.compterendu.entity.users.Administrateur;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Compte;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
@RequestMapping("/administrateur")
public class AdministrateurService   implements Serializable {
	@Autowired(required = true)
	private AdministrateurRepository administrateurrepository ;
	@Autowired(required=true)
	private EmployeeRepository employeerepository; 
	@Autowired(required=true)
	private Chef_equipeRepository chef_equiperepository;
	@GetMapping(value="getAll")
	public ResponseEntity<Object>  getUsers(){
			return new ResponseEntity<Object>(administrateurrepository.findAll(),HttpStatus.OK);
		}
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Administrateur a){
			return new ResponseEntity<Object>(administrateurrepository.save(a),HttpStatus.OK);	
		}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> save(@PathVariable Long id,@RequestBody Administrateur a  ){
			return new ResponseEntity<Object>(administrateurrepository.save(a),HttpStatus.OK);
		}	
	@PutMapping(value="/addEmployee/{id}")
	public void addEmployee (@RequestBody Employee a,@PathVariable Long id,@PathVariable String situation , String type_contrat,Long salaire_jour, Long salaire , String poste_desiree , String login, String mdp,String nom,String prenom,String sexe,Date date,String adresse,Long tel,String email) {
		a.setLogin(login);
		a.setMdp(mdp);
		a.setNom(nom);
		a.setPrenom(prenom);
		a.setSexe(sexe);
		a.setAdresse(adresse);
		a.setEmail(email);
		a.setTel(tel);
		a.setPoste_desiree(poste_desiree);
		a.setSituation(situation);
		a.setType_contrat(type_contrat);
		a.setSalaire(salaire);
		a.setSalaire_jour(salaire_jour);
		
		
		employeerepository.save(a);
	}
	@PutMapping(value="/addChef_equipe/{id}")
	public void addEmployee (@RequestBody Chef_equipe c,@PathVariable Long id,@PathVariable   String login, String mdp,String nom,String prenom,String sexe,Date date,String adresse,Long tel,String email) {
		c.setLogin(login);
		c.setMdp(mdp);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setSexe(sexe);
		c.setAdresse(adresse);
		c.setEmail(email);
		c.setTel(tel);
		chef_equiperepository.save(c);
	}
	@DeleteMapping(value = "/deleteChef_equipe/{id}")
	public ResponseEntity<Object> supprimerr(@PathVariable Long id){
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	@DeleteMapping(value = "/deleteemployee/{id}")
	public ResponseEntity<Object> supprimer(@PathVariable Long id){
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
	
}

package org.sid.compterendu.web;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.sid.compterendu.dao.AdministrateurRepository;
import org.sid.compterendu.dao.Chef_equipeRepository;
import org.sid.compterendu.dao.CompteeRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.sid.compterendu.dao.ProjetRepository;
import org.sid.compterendu.entity.Projet;
import org.sid.compterendu.entity.users.Administrateur;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Client;
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
	@Autowired(required=true)
	private ProjetRepository projetrepository;
	@GetMapping(value="getAll")
	public ResponseEntity<Object>  getUsers(){
			return new ResponseEntity<Object>(administrateurrepository.findAll(),HttpStatus.OK);
		}
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Administrateur a){
			return new ResponseEntity<Object>(administrateurrepository.save(a),HttpStatus.OK);	
		}
	
	//@PutMapping(value = "/update/{id}")
	//public ResponseEntity<Object> save(@PathVariable Long id,@RequestBody Administrateur a  ){
	//		return new ResponseEntity<Object>(administrateurrepository.save(a),HttpStatus.OK);
		//}	
	@PostMapping(value="/addEmployee/{id}")
	public void addEmployee (@RequestBody Employee a,@PathVariable Long id,@PathVariable String situation , String type_contrat,Long salaire_jour, Long salaire , String poste_desiree , String login, String mdp,String nom,String prenom,String sexe,Date date,String adresse,Long tel,String email,String avatar,Chef_equipe   chef_equipe,Date datedebut,String matricule) {
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
		a.setAvatar(avatar);
		a.setChef_equipe(chef_equipe);
		a.setDatedebut(datedebut);
		a.setMatricule(matricule);
		a.setSalaire_jour(salaire_jour);
		a.setType_contrat(type_contrat);
		
		
		employeerepository.save(a);
	}
	@PostMapping(value="/addChef_equipe/{id}")
	public void addEmployee (@RequestBody Chef_equipe c,@PathVariable Long id,@PathVariable   String login, String mdp,String nom,String prenom,String sexe,Date date,String adresse,Long tel,String email,Long salaire) {
		c.setLogin(login);
		c.setMdp(mdp);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setSexe(sexe);
		c.setAdresse(adresse);
		c.setEmail(email);
		c.setTel(tel);
		c.setSalaire(salaire);
		
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
	
	@PutMapping(value = "/updateEmploye/{id}")
	public void update(@RequestBody Employee e,@PathVariable Long id,@PathVariable String situation , String type_contrat,Long salaire_jour, Long salaire , String poste_desiree , String login, String mdp,String nom,String prenom,String sexe,Date date,String adresse,Long tel,String email){
		e.setLogin(login);
		e.setMdp(mdp);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setSexe(sexe);
		e.setAdresse(adresse);
		e.setEmail(email);
		e.setTel(tel);
		employeerepository.save(e);
	}
	
	
	@PostMapping(value="/addProjet/{id}")
	public void addProjet (@RequestBody Projet p ,@PathVariable Long id,String NomProjet,int NbreTache,String Description,Date DateDebut,Date DateFin,Long Hsupp,Chef_equipe chef_equipe,Client client) {
		p.setId(id);
		p.setNomProjet(NomProjet);
		p.setNbreTache(NbreTache);
		p.setDescription(Description);
		p.setDateDebut(DateDebut);
		p.setDateFin(DateFin);
		p.setHsupp(Hsupp);
		p.setChef_equipe(chef_equipe);
		p.setClient(client);
		projetrepository.save(p);
	}
	@PostMapping(value="/EditProjet/{id}")
	public void EditProjet (@RequestBody Projet f ,@PathVariable Long id,String NomProjet,int NbreTache,String Description,Date DateDebut,Date DateFin,Long Hsupp,Chef_equipe chef_equipe,Client client) {
		f.setId(id);
		f.setNomProjet(NomProjet);
		f.setNbreTache(NbreTache);
		f.setDescription(Description);
		f.setDateDebut(DateDebut);
		f.setDateFin(DateFin);
		f.setHsupp(Hsupp);
		f.setChef_equipe(chef_equipe);
		f.setClient(client);
		projetrepository.save(f);
	}
	
	
	
	
	
	
		
	
	
	

}


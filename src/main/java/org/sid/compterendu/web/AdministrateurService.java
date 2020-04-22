package org.sid.compterendu.web;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.sid.compterendu.dao.AdministrateurRepository;
import org.sid.compterendu.dao.Chef_equipeRepository;
import org.sid.compterendu.dao.ClientRepository;
import org.sid.compterendu.dao.CompteeRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.sid.compterendu.dao.ProjetRepository;
import org.sid.compterendu.dao.TacheRepository;
import org.sid.compterendu.entity.Projet;
import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.users.Administrateur;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Client;
import org.sid.compterendu.entity.users.Compte;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
	@Autowired(required=true)
	private TacheRepository tacherepository;
	@Autowired
	private ClientRepository clientrepositroy ;

	@GetMapping(value="getEmployee")
	public ResponseEntity<Object>  getLogin(){
			return new ResponseEntity<Object>(employeerepository.findAll(),HttpStatus.OK);
		}
	
		
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Administrateur a){
			return new ResponseEntity<Object>(administrateurrepository.save(a),HttpStatus.OK);	
		}
	
	@PostMapping(value="/addEmployee")
	public void addEmployee (@RequestBody Employee a) {		
		
		
		employeerepository.save(a);
	}
	@PostMapping(value="/addChef_equipe/{id}")
	public void addEmployee (@RequestBody Chef_equipe c) {
		
		chef_equiperepository.save(c);
	}
	
	@DeleteMapping(value = "/deleteChef_equipe/{id}")
	public Map<String, Boolean> deleteChef_equipe(@PathVariable Long id)
			throws ResourceNotFoundException {
		Chef_equipe chef_equipe = chef_equiperepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de chef_equipe :: " + id));

		chef_equiperepository.delete(chef_equipe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	@PutMapping(value = "/updateEmploye/{id}")
	public ResponseEntity<Employee> update(@RequestBody Employee e,@PathVariable Long id){
		Employee employee = employeerepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Pas d'employee  :: " + id));
		 employee.setLogin(e.getLogin());
		 employee.setMdp(e.getMdp());
		 employee.setNom(e.getNom());
		 employee.setPrenom(e.getPrenom());
		 employee.setAdresse(e.getAdresse());
		 employee.setSexe(e.getSexe());
		 employee.setAvatar(e.getAvatar());
		 employee.setEmail(e.getEmail());
		 employee.setDatedebut(e.getDatedebut());
		 employee.setMatricule(e.getMatricule());
		 employee.setPoste_desiree(e.getPoste_desiree());
		 employee.setSalaire(e.getSalaire());
		 employee.setSalaire_jour(e.getSalaire_jour());
		 employee.setSituation(e.getSituation());
		 employee.setTel(e.getTel());
		 employee.setType_contrat(e.getType_contrat());
		 employee.setChef_equipe(e.getChef_equipe());
		 employee.setClient(e.getClient());
		 Employee updateEmploye=employeerepository.save(e);
		
		return ResponseEntity.ok(updateEmploye);
	}
	
	
	@PostMapping(value="/addProjet/{id}")
	public void addProjet (@RequestBody Projet p ) {
	
		projetrepository.save(p);
	}
	@PutMapping(value="/EditProjet/{id}")
	public void EditProjet (@RequestBody Projet f,@PathVariable Long id ) {
		Projet projet = projetrepository.findById(id)
	   .orElseThrow(() -> new ResourceNotFoundException("Pas de projet  :: " + id));
		projet.setNomProjet(f.getNomProjet());
		projet.setNbreTache(f.getNbreTache());
		projet.setDateDebut(f.getDateDebut());
		projet.setDateFin(f.getDateFin());
		projet.setDescription(f.getDescription());
		projet.setHsupp(f.getHsupp());
		projet.setSutiationActuel(f.getSutiationActuel());
		projet.setChef_equipe(f.getChef_equipe());
		projet.setClient(f.getClient());
		projetrepository.save(f);
	}
	@DeleteMapping(value = "/deleteProjet /{id}")
	public Map<String, Boolean> deleteProjet(@PathVariable Long id)
			throws ResourceNotFoundException {
		Projet projet = projetrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas d'employe :: " + id));

		projetrepository.delete(projet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable Long id)
			throws ResourceNotFoundException {
		Employee employe = employeerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas d'employe :: " + id));

		employeerepository.delete(employe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	
	
	
	@PutMapping(value="/editChef_equipe/{id}")
	public ResponseEntity<Chef_equipe> editChef_equipe (@RequestBody Chef_equipe c,@PathVariable Long id ) {
		Chef_equipe chef_equipe = chef_equiperepository.findById(id)
	   .orElseThrow(() -> new ResourceNotFoundException("Pas de projet  :: " + id));
		chef_equipe.setLogin(c.getLogin());
		chef_equipe.setMdp(c.getMdp());
		chef_equipe.setNom(c.getNom());
		chef_equipe.setPrenom(c.getPrenom());
		chef_equipe.setAdresse(c.getAdresse());
		chef_equipe.setSexe(c.getSexe());
		chef_equipe.setAvatar(c.getAvatar());
		chef_equipe.setEmail(c.getEmail());
		chef_equipe.setSalaire(c.getSalaire());
		chef_equipe.setTel(c.getTel());
		chef_equipe.setProjett(c.getProjett());
		Chef_equipe editChef_equipe=chef_equiperepository.save(c);
		
		return ResponseEntity.ok(editChef_equipe);
	}
	
	@PostMapping(value="/addtache")
	public void addProjet (@RequestBody Tache t ) {
		
		tacherepository.save(t);
	}
	
	@PutMapping(value="/editTache/{id}")
	public ResponseEntity<Tache> editTache (@RequestBody Tache t,@PathVariable Long id ){
		Tache tache = tacherepository.findById(id)
	   .orElseThrow(() -> new ResourceNotFoundException("Pas de tache  :: " + id));
		tache.setNomTache(t.getNomTache());
		tache.setDateTache(t.getDateTache());
		tache.setDelaiTache(t.getDelaiTache());
		tache.setDescription(t.getDescription());
		tache.setChef_equipe(t.getChef_equipe());
		tache.setProjet(t.getProjet());
		Tache editTache=tacherepository.save(t);
		return ResponseEntity.ok(editTache);

	}
	
	@DeleteMapping("/deletetache/{id}")
	public Map<String, Boolean> deletetache(@PathVariable Long id)
			throws ResourceNotFoundException {
		Tache tache = tacherepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de tache :: " + id));

		tacherepository.delete(tache);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
	@PostMapping(value="/addclient")
	public void addEmployee (@RequestBody Client a) {		
	
		clientrepositroy.save(a);
	
	}
	
	@DeleteMapping("/deleteclient/{id}")
	public Map<String, Boolean> deleteclient(@PathVariable Long id)
			throws ResourceNotFoundException {
		Client client = clientrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de client :: " + id));

		clientrepositroy.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	@RequestMapping(value="/searchtache",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Tache> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return tacherepository.chercher("%"+mc+"%",PageRequest.of(page,size));
		
		
	}
	
		
	
	
}
	


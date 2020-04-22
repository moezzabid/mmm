package org.sid.compterendu.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.sid.compterendu.dao.Chef_equipeRepository;
import org.sid.compterendu.dao.CongeeChefRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.sid.compterendu.dao.TacheRepository;
import org.sid.compterendu.entity.CongeeChef;
import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chef_equipe")
public class ChefequipeService implements Serializable{
@Autowired
 private Chef_equipeRepository chef_equiperepository ;
@Autowired
private CongeeChefRepository congeechefrepository;
@Autowired
private TacheRepository tacherepository ;
@Autowired
private EmployeeRepository employeerepository ;
@PostMapping(value="/addCongee/{id}")
public void addEmployee (@RequestBody CongeeChef a) {		
	
	
	congeechefrepository.save(a);
}
@DeleteMapping(value = "/deleteCongee/{id}")
public Map<String, Boolean> deleteCongee(@PathVariable Long id)
		throws ResourceNotFoundException {
	CongeeChef congeechef = congeechefrepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Pas de congee :: " + id));

	congeechefrepository.delete(congeechef);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Supprimer", Boolean.TRUE);
	return response;
}
@PostMapping(value="/addTache/{id}")
public void addtache (@RequestBody Employee c,Tache t ,@PathVariable Long id) {		
	Tache tache = tacherepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pas de tache  :: " + id));
	Employee employee=employeerepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pas d'employee  :: " + id));
	//employee.getTache();
	employee.setTache(c.getTache());
	
	employeerepository.save(c);
}




}

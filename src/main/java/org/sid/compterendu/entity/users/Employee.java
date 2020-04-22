package org.sid.compterendu.entity.users;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.sid.compterendu.entity.Tache;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id")

@Data @AllArgsConstructor @NoArgsConstructor
public class Employee extends Compte {
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="poste_desiree")
	private String poste_desiree   ;
	@Column(name="matricule")
	private String matricule   ;
	@Column(name="situation")
	private String situation  ;
	@Column(name="type_contrat")
	private String type_contrat   ;
	@Column(name="datedebut")
	private Date datedebut  ;
	
	@Column(name="salaire_par_jour")
	private Long salaire_jour ;
	
	
	@ManyToOne
	private Administrateur administrateur;
	@ManyToOne
	private Chef_equipe chef_equipe;
	@ManyToOne
	private Client client;
	@OneToOne
	private Tache tache ;

	

}

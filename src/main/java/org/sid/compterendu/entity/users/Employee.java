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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
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
	@Column(name="salaire")
	private Long salaire ;
	@Column(name="salaire_par_jour")
	private Long salaire_jour ;
	@Column(name="img")
	private String avatar;
	@Column(name="Administrateur")
	@ManyToOne
	private Administrateur administrateur;
	@Column(name="Superviseur")
	@ManyToOne
	private Chef_equipe chef_equipe;
	@Column(name="client")
	@ManyToOne
	private Client client;
	

	

}

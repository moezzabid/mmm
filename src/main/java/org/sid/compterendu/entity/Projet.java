package org.sid.compterendu.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.sid.compterendu.entity.users.Administrateur;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Client;
import org.sid.compterendu.entity.users.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "projet")

@Data @AllArgsConstructor @NoArgsConstructor

public class Projet  {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@Column(name="NomProjet")
	private String NomProjet;
	@Column(name="NbreTache")
	private int NbreTache ;
	@Column(name="Description")
	private String Description ;
	@Column(name="DateDebut")
	private Date DateDebut;
	@Column(name="DateFin")
	private Date DateFin ;
	@Column(name="Hsupp")
	private Long Hsupp;
	@Column(name="client")
	private Client client ;
	@Column(name="situation")
	private String SutiationActuel ;
	
	
	
	
	@ManyToOne
	private Chef_equipe chef_equipe ;
	
	

	

	
	

}

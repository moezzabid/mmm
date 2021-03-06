package org.sid.compterendu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.sid.compterendu.entity.users.Administrateur;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Client;
import org.sid.compterendu.entity.users.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "tache")
@PrimaryKeyJoinColumn(name = "id")

@Data @AllArgsConstructor @NoArgsConstructor
public class Tache {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@Column(name="NomTache")
	private String NomTache ;
	@Column(name="DateTache")
	private Date DateTache;
	@Column(name="Description")
	private String Description;
	@Column(name="DelaiTache")
	private Date DelaiTache;
	
	//@ManyToMany
	private Chef_equipe chef_equipe ;
	
	@OneToOne
	private Employee employee ;
	@ManyToOne
	private Projet projet;
	
	
	
	

}

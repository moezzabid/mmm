package org.sid.compterendu.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Compte implements Serializable  {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="login")
	private String login  ;
	@Column(name="mdp")
	private String mdp  ;
	@Column(name="nom")
	private String nom  ;
	@Column(name="prenom")
	private String prenom ;
	@Column(name="sexe")
	private String sexe ; 
	@Column(name="adresse")
	private String adresse  ;
	@Column(name="email")
	private String email  ;
	@Column(name="tel")
	private Long tel   ;
}

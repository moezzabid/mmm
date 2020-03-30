package org.sid.compterendu.entity.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chef_equipe")
@PrimaryKeyJoinColumn(name = "id")

@Data @AllArgsConstructor @NoArgsConstructor
public class Client extends Compte {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	@Column(name="nom_societe")
	private String nom_societe;
	@Column(name="poste_occupe")
	private String poste_occupe;
	@Column(name="Administrateur")
	@ManyToOne
	private Administrateur administrateur;
	@Column(name="Superviseur")
	@ManyToOne
	private Chef_equipe chef_equipe;
	
}

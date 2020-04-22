package org.sid.compterendu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tache")
@PrimaryKeyJoinColumn(name = "id")

@Data @AllArgsConstructor @NoArgsConstructor
public class Travail {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@Column(name="Probleme")
	private String probleme ;
	@Column(name="objectif")
	private String objectif ;
	@Column(name="poste_employee")
	private String poste_employee;
	@Column(name="date")
	private Date date ;

	@ManyToOne
	private Employee employee;

}

package org.sid.compterendu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.sid.compterendu.entity.users.Chef_equipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "CongeeEmployee")

@Data @AllArgsConstructor @NoArgsConstructor

public class CongeeEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="datedebut")
	private Date datedebut ;
	
	@Column(name="datefin")
	private Date datefin;
	
	@Column(name="raison")
	private String raison ;
	
	@Column(name="Duree")
	private Date Duree ;
	
	@OneToOne
	private Chef_equipe chef_equipe;
}

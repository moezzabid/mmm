package org.sid.compterendu.entity.users;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.sid.compterendu.entity.Projet;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@JsonSerialize
//@Data @AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public  class Administrateur extends Compte {
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
}

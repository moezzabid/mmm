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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.sid.compterendu.entity.Projet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chef_equipe")
@PrimaryKeyJoinColumn(name = "id")

@Data @AllArgsConstructor @NoArgsConstructor
public class Chef_equipe extends Compte{
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	@Column(name="projet")
	@OneToMany
	private Collection <Projet> projett ;
	
	
	
	
	
	
}

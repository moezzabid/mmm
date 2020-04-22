package org.sid.compterendu.dao;

import java.util.Date;

import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.sid.compterendu.entity.users.Client;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
	@Query("select p from Tache p where p.NomTache like :x")
	public Page<Tache> chercher (@Param("x")String mc,Pageable pageable);

}

package org.sid.compterendu.dao;

import org.sid.compterendu.entity.users.Administrateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {


	

}

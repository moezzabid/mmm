package org.sid.compterendu.dao;

import org.sid.compterendu.entity.Projet;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}

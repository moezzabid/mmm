package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sid.compterendu.entity.Projet;
public interface ProjetRepository extends JpaRepository<Projet, Long> {

}

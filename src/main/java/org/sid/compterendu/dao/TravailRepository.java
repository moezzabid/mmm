package org.sid.compterendu.dao;

import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.Travail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravailRepository extends JpaRepository<Travail, Long> {

}

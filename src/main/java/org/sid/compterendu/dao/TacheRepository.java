package org.sid.compterendu.dao;

import org.sid.compterendu.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache,Long> {
}



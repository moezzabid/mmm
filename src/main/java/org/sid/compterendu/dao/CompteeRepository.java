package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sid.compterendu.entity.users.Compte;
@Repository
public interface CompteeRepository extends JpaRepository<Compte, Long> {

}

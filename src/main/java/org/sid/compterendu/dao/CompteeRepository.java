package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sid.compterendu.entity.users.Compte;
public interface CompteeRepository extends JpaRepository<Compte, Long> {

}

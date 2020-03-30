package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sid.compterendu.entity.users.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

}

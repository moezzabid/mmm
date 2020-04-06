package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sid.compterendu.entity.users.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

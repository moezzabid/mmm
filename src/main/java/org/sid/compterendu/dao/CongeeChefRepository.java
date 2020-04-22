package org.sid.compterendu.dao;

import org.sid.compterendu.entity.CongeeChef;
import org.sid.compterendu.entity.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeeChefRepository extends JpaRepository<CongeeChef, Long> {

}

package org.sid.compterendu.dao;

import org.sid.compterendu.entity.CongeeEmployee;
import org.sid.compterendu.entity.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeeEmployeeRepository extends JpaRepository<CongeeEmployee, Long> {

}

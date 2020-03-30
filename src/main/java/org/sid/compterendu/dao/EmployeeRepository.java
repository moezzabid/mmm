package org.sid.compterendu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.sid.compterendu.entity.users.Employee;
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package org.sid.compterendu.dao;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface Chef_equipeRepository extends JpaRepository<Chef_equipe,Long> {

}
package org.sid.compterendu.dao;
import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.users.Chef_equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
@Repository
public interface Chef_equipeRepository extends JpaRepository<Chef_equipe,Long> {
	

}

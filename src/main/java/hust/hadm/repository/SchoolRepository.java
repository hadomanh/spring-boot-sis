package hust.hadm.repository;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import hust.hadm.entity.School;

@Repository
//@RepositoryRestResource(path = "universities")
public interface SchoolRepository extends MainRepository<School> {

}

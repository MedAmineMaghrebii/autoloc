package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.entities.Employe;

@Repository
public interface IEmployeRepository extends CrudRepository<Employe, Long> {
}
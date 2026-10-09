package tn.esprit.autoloc.repository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.entities.Contrat;
public interface IContratRepository extends CrudRepository<Contrat, Long> {

}
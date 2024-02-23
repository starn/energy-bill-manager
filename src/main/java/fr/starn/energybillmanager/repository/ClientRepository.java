package fr.starn.energybillmanager.repository;

import fr.starn.energybillmanager.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}

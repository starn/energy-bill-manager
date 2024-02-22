package fr.starn.energybillmanager.repository;

import fr.starn.energybillmanager.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Client, Long> {
}

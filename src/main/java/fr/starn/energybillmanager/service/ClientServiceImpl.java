package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client get(long id) {
        return  clientRepository.findById(id).orElseThrow();
    }

}

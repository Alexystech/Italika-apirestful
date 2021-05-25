package com.itsx.slasher.italikaapirest.service.impl;

import com.itsx.slasher.italikaapirest.entity.Client;
import com.itsx.slasher.italikaapirest.repository.ClientRepository;
import com.itsx.slasher.italikaapirest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean createClient(Client client) {
        if ( client != null ) {
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeClientByFolio(long folio) {
        if ( folio > 0 ) {
            clientRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        if ( client != null ) {
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public Client getClientByFolio(long folio) {
        return clientRepository.findById(folio).get();
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return clients;
    }
}

package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.Client;

import java.util.List;

public interface ClientService {
    boolean createClient(Client client);
    boolean removeClientByFolio(long folio);
    boolean updateClient(Client client);
    Client getClientByFolio(long folio);
    List<Client> getAllClients();
}

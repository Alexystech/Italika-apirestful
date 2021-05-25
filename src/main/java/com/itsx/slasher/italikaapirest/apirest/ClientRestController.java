package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.Client;
import com.itsx.slasher.italikaapirest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * To create a new client
     * @param client
     * @return
     */
    @PostMapping("/create/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        if ( client == null ) {
            throw new RuntimeException("this client is null");
        }

        clientService.createClient(client);

        return ResponseEntity.ok(client);
    }

    /**
     * Remove a client by folio
     * @param folio
     * @return
     */
    @DeleteMapping("/delete/client/{folio}")
    public ResponseEntity<Boolean> deleteClientByFolio(@PathVariable Long folio) {

        Client client = clientService.getClientByFolio(folio);

        if ( client == null ) {
            throw new RuntimeException("client doesn't exist - " + folio);
        }

        clientService.removeClientByFolio(folio);

        return ResponseEntity.ok(true);
    }

    /**
     * Update a client
     * @param client
     * @return
     */
    @PutMapping("/update/client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {

        if ( client == null ) {
            throw new RuntimeException("The client is null");
        }

        clientService.updateClient(client);

        return ResponseEntity.ok(client);
    }

    /**
     * To get a client by folio
     * @param folio
     * @return
     */
    @GetMapping("/get/client/{folio}")
    public ResponseEntity<Client> getClientByFolio(@PathVariable Long folio) {

        Client client = clientService.getClientByFolio(folio);

        if ( client == null ) {
            throw new RuntimeException("client doesn't exist - " + folio);
        }

        return ResponseEntity.ok(client);
    }

    /**
     * To get all clients
     * @return
     */
    @GetMapping("/get/all/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

}

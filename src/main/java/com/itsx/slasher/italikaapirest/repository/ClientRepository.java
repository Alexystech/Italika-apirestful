package com.itsx.slasher.italikaapirest.repository;

import com.itsx.slasher.italikaapirest.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}

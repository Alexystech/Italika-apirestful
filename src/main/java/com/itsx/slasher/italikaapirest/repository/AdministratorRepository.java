package com.itsx.slasher.italikaapirest.repository;

import com.itsx.slasher.italikaapirest.entity.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}

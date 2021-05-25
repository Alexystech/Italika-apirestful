package com.itsx.slasher.italikaapirest.repository;

import com.itsx.slasher.italikaapirest.entity.TypeOfWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfWorkRepository extends CrudRepository<TypeOfWork, Long> {
}

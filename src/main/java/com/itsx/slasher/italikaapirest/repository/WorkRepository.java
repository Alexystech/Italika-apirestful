package com.itsx.slasher.italikaapirest.repository;

import com.itsx.slasher.italikaapirest.entity.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
}

package com.itsx.slasher.italikaapirest.service.impl;

import com.itsx.slasher.italikaapirest.entity.TypeOfWork;
import com.itsx.slasher.italikaapirest.repository.TypeOfWorkRepository;
import com.itsx.slasher.italikaapirest.service.TypeOfWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService {

    private TypeOfWorkRepository typeOfWorkRepository;

    @Autowired
    public TypeOfWorkServiceImpl(TypeOfWorkRepository typeOfWorkRepository) {
        this.typeOfWorkRepository = typeOfWorkRepository;
    }

    @Override
    public boolean createTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            typeOfWorkRepository.save(typeOfWork);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeTypeOfWorkByFolio(long folio) {
        if ( folio > 0 ) {
            typeOfWorkRepository.deleteById(folio);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTypeOfWork(TypeOfWork typeOfWork) {
        if ( typeOfWork != null ) {
            typeOfWorkRepository.save(typeOfWork);
            return true;
        }
        return false;
    }

    @Override
    public TypeOfWork getTypeOfWorkByFolio(long folio) {
        return typeOfWorkRepository.findById(folio).get();
    }

    @Override
    public List<TypeOfWork> getAllTypeOfWorks() {
        List<TypeOfWork> typeOfWorks = (List<TypeOfWork>) typeOfWorkRepository.findAll();
        return typeOfWorks;
    }
}

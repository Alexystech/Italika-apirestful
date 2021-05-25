package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    boolean createTypeOfWork(TypeOfWork typeOfWork);
    boolean removeTypeOfWorkByFolio(long folio);
    boolean updateTypeOfWork(TypeOfWork typeOfWork);
    TypeOfWork getTypeOfWorkByFolio(long folio);
    List<TypeOfWork> getAllTypeOfWorks();
}

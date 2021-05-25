package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    boolean createAdministrator(Administrator administrator);
    boolean removeAdministratorByFolio(long folio);
    boolean updateAdministrator(Administrator administrator);
    Administrator getAdministratorByFolio(long folio);
    List<Administrator> getAllAdministrators();
}

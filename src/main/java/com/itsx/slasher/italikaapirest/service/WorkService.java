package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.Work;

import java.util.List;

public interface WorkService {
    boolean createWork(Work work);
    boolean removeWorkByFolio(long folio);
    boolean updateWork(Work work);
    Work getWorkByFolio(long folio);
    List<Work> getAllWorks();
}

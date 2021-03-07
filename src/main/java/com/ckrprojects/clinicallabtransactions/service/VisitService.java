package com.ckrprojects.clinicallabtransactions.service;

import com.ckrprojects.clinicallabtransactions.dao.VisitRepository;
import com.ckrprojects.clinicallabtransactions.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    public Visit getVisitByid(String id) {
        final Optional<Visit> visitOptional = visitRepository.findById(id);
        if (visitOptional.isPresent()) {
            return visitOptional.get();
        }
        throw new NoSuchElementException(id);
    }

    public Visit update(Visit visit) {
        return visitRepository.save(visit);
    }

    public void delete(String id) {
        Visit visit = getVisitByid(id);
    }
}

package com.ckrprojects.clinicallabtransactions.service;

import com.ckrprojects.clinicallabtransactions.dao.TestRepository;
import com.ckrprojects.clinicallabtransactions.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public Test getVisitByid(Integer id) {
        final Optional<Test> testOptional =
                testRepository.findById(id);
        if (testOptional.isPresent()) {
            return testOptional.get();
        }
        throw new NoSuchElementException(Integer.toString(id));
    }

    public Test update(Test test) {
        return testRepository.save(test);
    }

    public void delete(int id) {
        Test test = getVisitByid(id);
        testRepository.delete(test);
    }
}

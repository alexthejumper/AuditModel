package com.example.auditmodel.repository;

import com.example.auditmodel.abstractRepo.AbstractRepository;
import com.example.auditmodel.entity.Visitor;

import java.util.List;

public interface VisitorRepository extends AbstractRepository<Visitor> {

    List<Visitor> findBySignOutTimeIsNull();
}

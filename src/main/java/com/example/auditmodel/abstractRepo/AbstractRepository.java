package com.example.auditmodel.abstractRepo;

import com.example.auditmodel.auditModel.AuditModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface AbstractRepository<T extends AuditModel> extends JpaRepository<T, UUID> {
}

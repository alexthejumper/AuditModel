package com.example.auditmodel.entity;

import com.example.auditmodel.auditModel.AuditModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Visitor extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Use AUTO or none for UUID generation
    private UUID id = UUID.randomUUID();  // Generate UUID in Java

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String contactDetails;

    @Column(nullable = false)
    private String detailsOfVisit;

    private String otherDetails;

    private LocalDateTime signInTime;

    private LocalDateTime signOutTime;
}

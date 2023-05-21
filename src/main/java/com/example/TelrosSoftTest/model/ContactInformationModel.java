package com.example.TelrosSoftTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contactInformation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class ContactInformationModel {

    @Id
    @Column(name = "id")
    //@SequenceGenerator(name = "userIdSeq", sequenceName = "id", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String name;
    private String email;

}

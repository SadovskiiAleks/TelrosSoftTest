package com.example.TelrosSoftTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "DetailedContactInformation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class DetailedContactInformationModel {

    @Id
    @Column(name = "id")
    private Long id;

    private String secondName;
    private LocalDateTime dateOfBirth;
    private Long phoneNumber;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id")
    public ContactInformationModel contactInformationModel;


}

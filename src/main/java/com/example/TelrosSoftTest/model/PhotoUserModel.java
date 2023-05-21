package com.example.TelrosSoftTest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PhotoUserModel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class PhotoUserModel {

    @Id
    @Column(name = "id")
    private Long id;


    //@Lob "невозможно получить доступ к большому потоку" неудалось корректно исправить ошибку
    // возможно поможет анотация  @Transactional
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id")
    public ContactInformationModel contactInformationModel;

}

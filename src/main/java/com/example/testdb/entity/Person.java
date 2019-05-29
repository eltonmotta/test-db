package com.example.testdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "TB_PERSON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dob;

}

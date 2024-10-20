package com.example.JoinCol.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tblReg")
public class Registers {


    @Id
    @Column(name = "regId")
    Integer regId;

    @Column(name = "fullname")
    String fullName;

    @OneToOne
    @JoinColumn(name = "regid", referencedColumnName = "regid", insertable = false, updatable = false)
    RegDevice registerDevice;
}

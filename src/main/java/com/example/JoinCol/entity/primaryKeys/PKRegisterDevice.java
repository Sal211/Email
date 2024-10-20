package com.example.JoinCol.entity.primaryKeys;


import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PKRegisterDevice implements Serializable {

    @Column(name = "regid")
    private Integer regId;

    @Column(name = "regDeviceId")
    private Integer regDeviceId;
}

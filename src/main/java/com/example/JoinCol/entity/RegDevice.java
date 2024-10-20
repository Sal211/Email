package com.example.JoinCol.entity;

import com.example.JoinCol.entity.primaryKeys.PKRegisterDevice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@IdClass(PKRegisterDevice.class)
@Getter
@Setter
@Table(name = "tblRegDevice")
public class RegDevice {

    @Id
    @Column(name = "regId")
    Integer regId;

    @Id
    @Column(name = "regDeviceId")
    Integer regDeviceId;

    @Column(name = "deviceModel")
    String deviceModel;

}

package com.example.JoinCol.repository;

import com.example.JoinCol.entity.RegDevice;
import com.example.JoinCol.entity.primaryKeys.PKRegisterDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDeviceRepository extends JpaRepository<RegDevice, PKRegisterDevice> {
}

package com.hospital.main.serviceImpl;

import com.hospital.main.bean.Doctor;
import com.hospital.main.dao.DoctorMapper;
import com.hospital.main.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("ALL")
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> getRandomDoctor() {
        return doctorMapper.getRandomDoctor();
    }
}

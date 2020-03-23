package com.hospital.serviceImpl;

import com.hospital.bean.Disease;
import com.hospital.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DiseaseServiceImpl")
public class DiseaseServiceImpl implements DiseaseService{
    @Override
    public List<Disease> showUser() {
        return null;
    }
}

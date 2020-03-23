package com.hospital.main.serviceImpl;

import com.hospital.main.bean.DisCategory;
import com.hospital.main.bean.Disease;
import com.hospital.main.dao.DiseaseMapper;
import com.hospital.main.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("ALL")
@Service
@Transactional
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    public DiseaseMapper diseaseMapper;

    @Override
    public List<Disease> getDisCategory() {
        return diseaseMapper.getDisCategory();
    }

    @Override
    public List<Disease> getRandomDisease() {
        return diseaseMapper.getRandomDisease();
    }

    @Override
    public Disease getDiseaseById(long id) {
        return diseaseMapper.getDiseaseById(id);
    }
}

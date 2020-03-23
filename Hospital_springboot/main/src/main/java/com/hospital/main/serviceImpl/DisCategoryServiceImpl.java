package com.hospital.main.serviceImpl;

import com.hospital.main.bean.DisCategory;
import com.hospital.main.dao.DisCategoryMapper;
import com.hospital.main.service.DisCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("ALL")
@Service
public class DisCategoryServiceImpl implements DisCategoryService {
    @Autowired
    public DisCategoryMapper disCategoryMapper;

    @Override
    public List<DisCategory> getAllDisCategory() {
        return disCategoryMapper.getAllDisCategory();
    }
}

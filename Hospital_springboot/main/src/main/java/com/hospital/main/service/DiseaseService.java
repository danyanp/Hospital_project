package com.hospital.main.service;

import com.hospital.main.bean.Disease;

import java.util.List;

public interface DiseaseService {
    //获取所有疾病分类
    public List<Disease> getDisCategory();
    //随机获取10个病
    public List<Disease> getRandomDisease();
    //
    public Disease getDiseaseById(long id);
}

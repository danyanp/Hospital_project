package com.hospital.service;

import com.hospital.bean.Disease;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiseaseService {

    //获取全部疾病
    public List<Disease> showUser();
}

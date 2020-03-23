package com.hospital.main.serviceImpl;

import com.hospital.main.bean.Case;
import com.hospital.main.dao.CaseMapper;
import com.hospital.main.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    CaseMapper caseMapper;
    @Override
    public List<Case> getCaseByUserId(long id) {
        return caseMapper.getCaseByUserId(id);
    }
}

package com.hospital.main.service;

import com.hospital.main.bean.Case;

import java.util.List;

public interface CaseService {
    public List<Case> getCaseByUserId(long id);
}

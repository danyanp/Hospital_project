package com.hospital.main.dao;

import com.hospital.main.bean.Case;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CaseMapper extends Mapper<Case> {
    @Select("SELECT * FROM `case` WHERE UserID = \"1\"")
    public List<Case> getCaseByUserId(long id);
}

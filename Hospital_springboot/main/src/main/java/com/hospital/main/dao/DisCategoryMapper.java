package com.hospital.main.dao;

import com.hospital.main.bean.DisCategory;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DisCategoryMapper extends Mapper<DisCategory> {
    @Select("SELECT * FROM dis_category LIMIT 8")
    public List<DisCategory> getAllDisCategory();
}

package com.hospital.main.dao;

import com.hospital.main.bean.Doctor;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DoctorMapper extends Mapper<Doctor> {
    //随机找6名医生
    @Select("SELECT * FROM Doctor ORDER BY RAND() LIMIT 6")
    public List<Doctor> getRandomDoctor();
}

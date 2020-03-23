package com.hospital.main.dao;

import com.hospital.main.bean.Disease;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DiseaseMapper extends Mapper<Disease> {

   public List<Disease> getDisCategory();
   @Select("SELECT * FROM Disease WHERE DiseaseName!=\"\" ORDER BY RAND() LIMIT 10")
   public List<Disease> getRandomDisease();
   @Select("SELECT * FROM Disease WHERE DiseaseID = #{id}")
   public Disease getDiseaseById(long id);
}

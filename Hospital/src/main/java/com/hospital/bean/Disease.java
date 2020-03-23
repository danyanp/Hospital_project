package com.hospital.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

  private long id;
  private String diseaseName;
  private long disCategoryId;
  private String subCategory;
  private String category;
  private String diseaseDis;
  private String symptom;
  private String cause;

}

package com.hospital.main.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisCategory {
  private long disCategoryId;
  private String DiseaseName;
  private String categoryName;
  private long parentId;
}

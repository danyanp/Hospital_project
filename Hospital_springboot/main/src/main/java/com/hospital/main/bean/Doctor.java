package com.hospital.main.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

  private long doctorId;
  private String doctorName;
  private long sex;
  private java.sql.Date birthday;
  private String photo;
  private String title;
  private long hospitalId;
  private long disCategoryId;
  private String phoneNumber;
  private String email;
  private String introduction;

}

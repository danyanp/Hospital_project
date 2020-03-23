package com.hospital.main.bean;


public class Case {

  private long caseId;
  private long doctorId;
  private long userId;
  private String diseaseId;
  private String userDescription;
  private String doctorDescription;
  private java.sql.Timestamp caseTime;


  public long getCaseId() {
    return caseId;
  }

  public void setCaseId(long caseId) {
    this.caseId = caseId;
  }


  public long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(long doctorId) {
    this.doctorId = doctorId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getDiseaseId() {
    return diseaseId;
  }

  public void setDiseaseId(String diseaseId) {
    this.diseaseId = diseaseId;
  }


  public String getUserDescription() {
    return userDescription;
  }

  public void setUserDescription(String userDescription) {
    this.userDescription = userDescription;
  }


  public String getDoctorDescription() {
    return doctorDescription;
  }

  public void setDoctorDescription(String doctorDescription) {
    this.doctorDescription = doctorDescription;
  }


  public java.sql.Timestamp getCaseTime() {
    return caseTime;
  }

  public void setCaseTime(java.sql.Timestamp caseTime) {
    this.caseTime = caseTime;
  }

}

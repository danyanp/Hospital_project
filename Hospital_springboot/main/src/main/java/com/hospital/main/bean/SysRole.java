package com.hospital.main.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements GrantedAuthority {

  private long id;
  private String roleName;
  private String roleDesc;

  @JsonIgnore
  @Override
  public String getAuthority() {
    return roleName;
  }
}

package com.hospital.main.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements UserDetails {

  private long id;
  private String username;
  private String password;
  private long status;
  private long sex;
  private java.sql.Date birthday;
  private String phoneNumber;
  private String address;
  private String email;
  private String qq;
  private List<SysRole> roles;

  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return true;
  }
}

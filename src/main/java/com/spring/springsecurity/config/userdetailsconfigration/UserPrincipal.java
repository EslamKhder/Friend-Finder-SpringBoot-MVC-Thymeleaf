package com.spring.springsecurity.config.userdetailsconfigration;

import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private User user;

    @Autowired
    public UserPrincipal(User user){
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Extract list of roles (ROLE_name)
            this.user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getName());
            authorities.add(authority);
        });
        return authorities;
    }

   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> authorities;
        authorities = user.getRoles();
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    */

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        try {
            return this.user.getActive() == 1;
        } catch (Exception e){
            return false;
        }

    }
    public String getFullname(){
        return this.user.getUserProprites().getFullname();
    }
}

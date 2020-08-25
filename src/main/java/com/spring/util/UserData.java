package com.spring.util;

import com.spring.springsecurity.config.userdetailsconfigration.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserData {
    public static long userId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((UserPrincipal) principal).getId();
    }
}

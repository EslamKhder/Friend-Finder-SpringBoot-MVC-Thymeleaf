package com.spring.util;

import com.spring.springsecurity.config.userdetailsconfigration.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserData {
    public static long userId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((UserPrincipal) principal).getId();
    }

    public static String userImage(){
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String image = ((UserPrincipal) principal).getImage();
            return image;
        } catch (Exception e){
            return "default";
        }

    }
    public static boolean isConnected(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            return false;
        }
        return true;
    }
}

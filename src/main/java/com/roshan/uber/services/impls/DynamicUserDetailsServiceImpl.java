package com.roshan.uber.services.impls;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class DynamicUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RiderDetailsServiceImpl riderDetailsService;
    DriverDetailsServiceImpl driverDetailsService;

    public DynamicUserDetailsServiceImpl(RiderDetailsServiceImpl riderDetailsService, DriverDetailsServiceImpl driverDetailsService) {
        this.riderDetailsService = riderDetailsService;
        this.driverDetailsService = driverDetailsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userType = getUserTypeFromHeader();
        UserDetailsService dynamicUserDetailsService = getUserDetailsServiceByUserType(userType);

        return dynamicUserDetailsService.loadUserByUsername(username);
    }

    private String getUserTypeFromHeader() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        return request.getHeader("usertype");
    }

    private UserDetailsService getUserDetailsServiceByUserType(String userType) {
        if ("driver".equals(userType)) {
            return driverDetailsService;
        } else {
            return riderDetailsService;
        }
    }
}
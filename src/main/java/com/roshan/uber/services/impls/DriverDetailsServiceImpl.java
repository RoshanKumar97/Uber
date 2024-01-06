package com.roshan.uber.services.impls;

import com.roshan.uber.dtos.DriverDto;
import com.roshan.uber.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DriverDetailsServiceImpl implements UserDetailsService {
    @Autowired
    DriverService driverService;

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        DriverDto driverDto = driverService.getDriverByMobile(mobile);
        return new User(driverDto.getMobile(),driverDto.getPassword(),new ArrayList<>());
    }
}

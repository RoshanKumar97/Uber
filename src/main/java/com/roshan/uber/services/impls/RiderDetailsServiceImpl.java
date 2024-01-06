package com.roshan.uber.services.impls;

import com.roshan.uber.dtos.RiderDto;
import com.roshan.uber.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RiderDetailsServiceImpl implements UserDetailsService {
    @Autowired
    RiderService riderService;
    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        RiderDto riderDto = riderService.getRiderByMobile(mobile);
        return new User(riderDto.getMobile(),riderDto.getPassword(),new ArrayList<>());
    }
}

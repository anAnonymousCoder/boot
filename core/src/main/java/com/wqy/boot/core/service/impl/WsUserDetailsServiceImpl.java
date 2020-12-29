package com.wqy.boot.core.service.impl;

import com.wqy.boot.core.dao.UserDao;
import com.wqy.boot.core.domain.builder.UserBuilder;
import com.wqy.boot.core.domain.entity.Role;
import com.wqy.boot.core.domain.entity.User;
import com.wqy.boot.core.domain.security.WsUserDetails;
import com.wqy.boot.core.service.WsUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 实现UserDetailsService接口
 *
 * @author wqy
 * @version 1.0 2020/12/27
 */
@Service
@Transactional(readOnly = true)
public class WsUserDetailsServiceImpl implements WsUserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(WsUserDetailsService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            logger.info("User login failed because the user was not found, username: {}", username);
            throw new UsernameNotFoundException(username);
        }
        return getUserDetails(user);
    }

    public UserDetails getUserDetails(User user) {
        WsUserDetails wsUserDetails = UserBuilder.buildUserDetails(user);
        List<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new LinkedList<>();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        wsUserDetails.setAuthorities(authorities);
        return wsUserDetails;
    }


}

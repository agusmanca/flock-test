package com.flock.test.flocktest.service;

import com.flock.test.flocktest.dao.IUserDao;
import com.flock.test.flocktest.entity.User;
import com.flock.test.flocktest.models.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(JpaUserDetailsService.class);
    private IUserDao userDao;

    public JpaUserDetailsService(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = this.userDao.findByUsername(username);
        List<GrantedAuthority> authRole = new ArrayList<>();

        if(Objects.isNull(usuario)){
            log.error("Usuario no encontrado.");
            throw new UsernameNotFoundException("El usuario: " + username + " no existe en los registros.");
        }

        for(Role role: Role.values()){
            authRole.add(new SimpleGrantedAuthority(role.getValue()));
        }

        if(authRole.isEmpty()){
            log.error("No tiene permisos asignados a este usuarip.");
            throw new UsernameNotFoundException("No hay roles de usuario registrados.");
        }

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authRole);
    }
}

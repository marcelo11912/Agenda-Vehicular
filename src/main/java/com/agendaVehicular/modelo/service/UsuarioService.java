package com.agendaVehicular.modelo.service;

import com.agendaVehicular.modelo.entity.Authority;
import com.agendaVehicular.modelo.entity.Usuario;
import com.agendaVehicular.repository.IUsuarioRepository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario appUser
                = usuarioRepository.findByUsername(usuario).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
        List grantList = new ArrayList();
        for (Authority authority : appUser.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        UserDetails usu = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);

        return usu;

    }

}



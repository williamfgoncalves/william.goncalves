package br.com.crescer.social.security;

import br.com.crescer.social.Models.Usuario;
import br.com.crescer.social.service.UsuariosService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuariosService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario s = service.buscarPorEmail(username);
        return new User(s.getEmail(), s.getSenha(), new ArrayList<GrantedAuthority>());
    }
}

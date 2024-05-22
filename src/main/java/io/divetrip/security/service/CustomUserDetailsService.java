package io.divetrip.security.service;

import io.divetrip.domain.entity.Diver;
import io.divetrip.domain.entity.DiverRole;
import io.divetrip.domain.repository.DiverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final DiverRepository diverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return diverRepository.findByEmail(username)
                .map(this::getDiver)
                .orElseThrow(() -> new UsernameNotFoundException("Not found username: " + username));
    }

    private org.springframework.security.core.userdetails.User getDiver(Diver diver) {
        List<GrantedAuthority> authorities = diver.getDiverRoles().stream()
                .map(DiverRole::getRole)
                .map(role -> new SimpleGrantedAuthority(role.getRoleCode()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(diver.getEmail(), diver.getPassword(), authorities);
    }

}

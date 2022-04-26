package ru.lexp00.supermarket.msauth.services;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.msauth.entities.User;
import ru.lexp00.supermarket.msauth.repositories.UserRepository;
import ru.lexp00.supermarket.mscore.dto.users.UserDto;
import ru.lexp00.supermarket.mscore.exeptions.ResourceNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
//public class UserService implements UserDetailsService {

public class UserService {
    private final UserRepository userRepository;

    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::userToDto)
                .orElseThrow(()-> new ResourceNotFoundException("User with this username '" + username + "' is not found"));
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id).map(this::userToDto).orElseThrow();
    }

    private UserDto userToDto(User user) {
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .cashback(user.getCashback().getBonus())
                .build();
        return userDto;
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", username)));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }

}

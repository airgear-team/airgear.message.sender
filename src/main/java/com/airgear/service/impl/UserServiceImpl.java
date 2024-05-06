package com.airgear.service.impl;

import com.airgear.dto.GoodsSearchResponse;
import com.airgear.dto.UserGetResponse;
import com.airgear.dto.UserSaveRequest;
import com.airgear.exception.UserExceptions;
import com.airgear.mapper.GoodsMapper;
import com.airgear.mapper.UserMapper;
import com.airgear.model.CustomUserDetails;
import com.airgear.model.Role;
import com.airgear.model.User;
import com.airgear.model.UserStatus;
import com.airgear.repository.UserRepository;
import com.airgear.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Service(value = "userService")
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final GoodsMapper goodsMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email '" + email + "' not found"));

        return new CustomUserDetails(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserGetResponse getUserByEmail(String email) {
        User user = getUser(email);
        return userMapper.toDto(user);
    }

    @Override
    public UserGetResponse create(UserSaveRequest request) {
        validateUniqueFields(request);
        User user = save(request);
        return userMapper.toDto(user);
    }

    private void validateUniqueFields(UserSaveRequest request) {
        String email = request.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw UserExceptions.duplicateEmail(email);
        }
        String phone = request.getPhone();
        if (userRepository.existsByPhone(phone)) {
            throw UserExceptions.duplicatePhone(phone);
        }
    }

    private User save(UserSaveRequest request) {
        var user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setName(request.getName());
        user.setRoles(createRoles());
        user.setStatus(UserStatus.ACTIVE);
        user.setCreatedAt(OffsetDateTime.now());
        userRepository.save(user);
        return user;
    }

    private Set<Role> createRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        return roles;
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserExceptions.userNotFound(email));
    }
}

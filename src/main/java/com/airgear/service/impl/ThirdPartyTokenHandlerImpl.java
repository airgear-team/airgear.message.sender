package com.airgear.service.impl;

import com.airgear.dto.UserSaveRequest;
import com.airgear.model.CustomUserDetails;
import com.airgear.service.ThirdPartyDataHandler;
import com.airgear.service.ThirdPartyTokenHandler;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class ThirdPartyTokenHandlerImpl implements ThirdPartyTokenHandler {

    private final ThirdPartyDataHandler thirdPartyDataHandler;
    private final AuthenticationManager authenticationManager;

    @Override
    public CustomUserDetails execute(HttpServletRequest request) {
        UserSaveRequest userRequest = thirdPartyDataHandler.execute(request);
        return getCustomUserDetails(userRequest);
    }

    private CustomUserDetails getCustomUserDetails(UserSaveRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return (CustomUserDetails) authentication.getPrincipal();
    }
}

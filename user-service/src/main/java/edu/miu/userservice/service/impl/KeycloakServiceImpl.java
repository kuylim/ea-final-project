package edu.miu.userservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.userservice.dto.LoginDTO;
import edu.miu.userservice.dto.UserDTO;
import edu.miu.userservice.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KeycloakServiceImpl implements KeycloakService {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    @Value("${cli.password}")
    private String cliPassword;
    @Value("${cli.username}")
    private String cliUsername;
    @Value("${cli.client-id}")
    private String cliClientId;
    @Value("${cli.grant-type}")
    private String grantType;

    @Value("${cli.token-url}")
    private String cliTokenUrl;

    @Value("${cli.create-user-url}")
    private String createUserUrl;

    @Override
    public Map<String, Object> getAccessToken(LoginDTO dto) {
        return null;
    }

    @Override
    public Map<String, Object> createUser(UserDTO dto) {
        MultiValueMap<String, Object> payload = new LinkedMultiValueMap<>();
        payload.add("username", cliUsername);
        payload.add("password", cliPassword);
        payload.add("grant_type", grantType);
        payload.add("client_id", cliClientId);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(payload, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(cliTokenUrl, request, String.class);

            Map<String, String> res = mapper.readValue(Objects.requireNonNull(response).getBody(), Map.class);

            log.info("========> {}", res);
        } catch (Exception ex) {
            log.info("========> createUser error: ", ex);
        }
        return null;
    }
}

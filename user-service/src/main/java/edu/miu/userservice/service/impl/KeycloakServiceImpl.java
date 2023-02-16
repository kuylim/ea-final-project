package edu.miu.userservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.userservice.dto.LoginDTO;
import edu.miu.userservice.dto.UserDTO;
import edu.miu.userservice.dto.UserKeycloakDTO;
import edu.miu.userservice.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String GRANT_TYPE = "grant_type";
    private static final String CLIENT_ID = "client_id";
    private static final String ACCESS_TOKEN = "access_token";

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

    @Value("${app.client-id}")
    private String appClientId;

    @Value("${app.realm}")
    private String appRealm;

    @Override
    public Map<String, Object> getAccessToken(LoginDTO dto) {
        MultiValueMap<String, Object> payload = new LinkedMultiValueMap<>();
        payload.add(USERNAME, dto.getUsername());
        payload.add(PASSWORD, dto.getPassword());
        payload.add(GRANT_TYPE, grantType);
        payload.add(CLIENT_ID, appClientId);
        Map<String, Object> res = new HashMap<>();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(payload, headers);
            String url = String.format("http://localhost:5555/auth/realms/%s/protocol/openid-connect/token", appRealm);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            res = mapper.readValue(Objects.requireNonNull(response).getBody(), Map.class);
        } catch (Exception ex) {
            log.info("=========> getAccessToken error: ", ex);
        }
        return res;
    }

    @Override
    public Boolean createUser(UserDTO dto) {
        MultiValueMap<String, Object> payload = new LinkedMultiValueMap<>();
        payload.add(USERNAME, cliUsername);
        payload.add(PASSWORD, cliPassword);
        payload.add(GRANT_TYPE, grantType);
        payload.add(CLIENT_ID, cliClientId);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(payload, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(cliTokenUrl, request, String.class);

            Map<String, String> res = mapper.readValue(Objects.requireNonNull(response).getBody(), Map.class);

            if (!CollectionUtils.isEmpty(res)) {
                String token = "Bearer ".concat(res.get(ACCESS_TOKEN));

                UserKeycloakDTO userKeycloakDTO = new UserKeycloakDTO();

                BeanUtils.copyProperties(dto, userKeycloakDTO);

                userKeycloakDTO.setEnabled("true");

                UserKeycloakDTO.Credential credential = new UserKeycloakDTO.Credential();
                credential.setTemporary(false);
                credential.setType(PASSWORD);
                credential.setValue(dto.getPassword());

                userKeycloakDTO.setClientRoles(Map.of(appClientId, List.of(dto.getRole().name())));
                userKeycloakDTO.setCredentials(List.of(credential));

                headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Authorization", token);
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                HttpEntity<UserKeycloakDTO> entity = new HttpEntity<>(userKeycloakDTO, headers);
                restTemplate.postForEntity(createUserUrl, entity, String.class);
            }
        } catch (Exception ex) {
            log.info("=========> createUser in keycloak error: ", ex);
            return false;
        }
        return true;
    }
}

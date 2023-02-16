package edu.miu.userservice;

import edu.miu.userservice.dto.Credential;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.vault.support.Versioned;

import java.util.Map;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        VaultEndpoint vaultEndpoint = new VaultEndpoint();
//
//        vaultEndpoint.setHost("localhost");
//        vaultEndpoint.setPort(8200);
//        vaultEndpoint.setScheme("http");
//        VaultTemplate vaultTemplate = new VaultTemplate(vaultEndpoint,
//                new TokenAuthentication("00000000-0000-0000-0000-000000000000"));
//
//        Versioned<Map<String, Object>> readResponse = vaultTemplate
//                .opsForVersionedKeyValue("/secret").get("myapp");
//        log.info("====> {}", readResponse.getData().get("username"));
//        VaultResponseSupport<Map> response = vaultTemplate.read("ea/user-service", Map.class);
//        System.out.println(response);
    }

}

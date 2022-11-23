package edu.miu.userservice.service.impl;

import edu.miu.userservice.dto.UserDTO;
import edu.miu.userservice.entity.User;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.KeycloakService;
import edu.miu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeycloakService keycloakService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Boolean createUser(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user, "id");
        if (keycloakService.createUser(dto)) {
            user = userRepository.save(user);
            kafkaTemplate.send("movie-create-user", user);
            kafkaTemplate.send("tv-series-create-user", user);
        }
        return true;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            BeanUtils.copyProperties(dto, user, "id");
            userRepository.save(user);
        }
        return dto;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserDTO dto = new UserDTO();
        Optional<User> optional = userRepository.findById(id);
        optional.ifPresent(user -> BeanUtils.copyProperties(user, dto));
        return dto;
    }

    @Override
    public Boolean deleteUserById(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}

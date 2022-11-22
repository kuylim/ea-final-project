package edu.miu.userservice.service;

import edu.miu.userservice.dto.UserDTO;

/**
 * Author: Kuylim TITH
 * Date: 11/22/2022
 */
public interface UserService {

    UserDTO createUser(UserDTO dto);

    UserDTO updateUser(Long id, UserDTO dto);

    UserDTO findUserById(Long id);
}

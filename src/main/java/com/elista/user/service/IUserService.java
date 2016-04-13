package com.elista.user.service;

import com.elista.user.dto.UserDTO;
import java.util.List;

/**
 * Created by maciej.chyczewski on 2016-04-13.
 */
public interface IUserService {
    UserDTO findUserById(Long id);
    List<UserDTO> findAllUsers();
    List<UserDTO> findUsersByName(String name);
    List<UserDTO> findUsersByLastName(String lastName);
    List<UserDTO> findUsersByNames(String name, String lastName);
    UserDTO saveUser(UserDTO userDTO);
    boolean deleteUser(Long id);
}

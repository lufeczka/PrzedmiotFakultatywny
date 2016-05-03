package com.elista.user.service;

import com.elista.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public interface IUserService {
    List<UserDTO> getAllUsers();
}

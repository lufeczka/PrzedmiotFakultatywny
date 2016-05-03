package com.elista.functions.converters;

import com.elista.user.dto.UserDTO;
import com.elista.user.ob.UserOB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public class UserConverter {
    public static UserDTO UserOBToDTO(UserOB userOB){
        if(userOB == null)
            return null;
        return new UserDTO(userOB.getId(), PositionConverter.PositionOBToDTO(userOB.getPositions()), userOB.getEmail(), userOB.getPassword(), userOB.getName(), userOB.getSurname(), userOB.getPhoneNumber(), userOB.getAddress(), userOB.getActiveUntil());
    }

    public static List<UserDTO> UserOBToDTO(List<UserOB> UsersOB)
    {
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();

        for (UserOB userOB: UsersOB)
            usersDTO.add(UserOBToDTO(userOB));

        return usersDTO;
    }
}

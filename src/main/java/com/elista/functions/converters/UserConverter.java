package com.elista.functions.converters;

import com.elista.user.dto.userDTO;
import com.elista.user.ob.UserOB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public class UserConverter {
    public static userDTO UserOBToDTO(UserOB userOB){
        if(userOB == null)
            return null;
        return new userDTO(userOB.getId(), PositionConverter.positionObToDTO(userOB.getPositions()), userOB.getEmail(), userOB.getPassword(), userOB.getName(), userOB.getSurname(), userOB.getPhoneNumber(), userOB.getAddress(), userOB.getActiveUntil());
    }

    public static List<userDTO> UserOBToDTO(List<UserOB> UsersOB)
    {
        List<userDTO> usersDTO = new ArrayList<userDTO>();

        for (UserOB userOB: UsersOB)
            usersDTO.add(UserOBToDTO(userOB));

        return usersDTO;
    }
}

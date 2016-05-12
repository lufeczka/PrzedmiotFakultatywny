package com.elista.functions.converters;

import com.elista.position.dto.positionDTO;
import com.elista.position.ob.positionOb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public class PositionConverter {
    public static positionDTO positionObToDTO(positionOb positionOb) {
        if (positionOb == null)
            return null;

        return new positionDTO(positionOb.getDivision(), positionOb.getName(), positionOb.getCode());
    }

    public static List<positionDTO> positionObToDTO(List<positionOb> positionsOB){
        List<positionDTO> positionsDTO = new ArrayList<positionDTO>();

        for (com.elista.position.ob.positionOb positionOb: positionsOB)
            positionsDTO.add(positionObToDTO(positionOb));

        return positionsDTO;
    }
}

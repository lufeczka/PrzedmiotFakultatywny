package com.elista.functions.converters;

import com.elista.position.dto.PositionDTO;
import com.elista.position.ob.PositionOB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */
public class PositionConverter {
    public static PositionDTO PositionOBToDTO(PositionOB positionOB) {
        if (positionOB == null)
            return null;

        return new PositionDTO(positionOB.getDivision(), positionOB.getName(), positionOB.getCode());
    }

    public static List<PositionDTO> PositionOBToDTO(List<PositionOB> positionsOB){
        List<PositionDTO> positionsDTO = new ArrayList<PositionDTO>();

        for (PositionOB positionOB: positionsOB)
            positionsDTO.add(PositionOBToDTO(positionOB));

        return positionsDTO;
    }
}

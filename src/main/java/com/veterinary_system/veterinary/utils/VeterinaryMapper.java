package com.veterinary_system.veterinary.utils;

import com.veterinary_system.veterinary.dto.in.VeterinaryDTO;
import com.veterinary_system.veterinary.model.VeterinaryEntity;
import com.veterinary_system.veterinary.model.enums.PlanEnum;

public class VeterinaryMapper {

    public static VeterinaryDTO entityToDto(VeterinaryEntity veterinary) {
        return VeterinaryDTO
                .builder()
                .name(veterinary.getName())
                .description(veterinary.getDescription())
                .address(veterinary.getAddress())
                .phone(veterinary.getPhone())
                .whatsapp(veterinary.getWhatsapp())
                .build();
    }

    public static VeterinaryEntity dtoToEntity(VeterinaryDTO veterinaryDTO) {
        return VeterinaryEntity
                .builder()
                .name(veterinaryDTO.name())
                .description(veterinaryDTO.description())
                .address(veterinaryDTO.address())
                .phone(veterinaryDTO.phone())
                .whatsapp(veterinaryDTO.whatsapp())
                .plan(PlanEnum.COMMON.name())
                .build();
    }
}

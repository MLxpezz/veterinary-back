package com.veterinary_system.veterinary.service;

import com.veterinary_system.common.dto.ApiResponse;
import com.veterinary_system.veterinary.dto.in.VeterinaryDTO;

import java.util.List;

public interface VeterinaryService {

    VeterinaryDTO createVeterinary(VeterinaryDTO veterinaryDTO);

    VeterinaryDTO getVeterinaryById(Long id);

    List<VeterinaryDTO> getAllVeterinary();

    String deleteVeterinary(Long id);

    VeterinaryDTO updateVeterinary(Long id, VeterinaryDTO veterinaryDTO);
}

package com.veterinary_system.veterinary.service.impl;

import com.veterinary_system.common.enums.ApiMessage;
import com.veterinary_system.veterinary.dto.in.VeterinaryDTO;
import com.veterinary_system.veterinary.model.VeterinaryEntity;
import com.veterinary_system.veterinary.repository.VeterinaryRepository;
import com.veterinary_system.veterinary.service.VeterinaryService;
import com.veterinary_system.veterinary.utils.VeterinaryMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinaryServiceImpl implements VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;

    public VeterinaryServiceImpl(VeterinaryRepository veterinaryRepository) {
        this.veterinaryRepository = veterinaryRepository;
    }

    @Override
    public VeterinaryDTO createVeterinary(VeterinaryDTO veterinaryDTO) {

        VeterinaryEntity veterinary = VeterinaryMapper.dtoToEntity(veterinaryDTO);

        VeterinaryEntity newVeterinary = veterinaryRepository.save(veterinary);

        return VeterinaryMapper.entityToDto(newVeterinary);
    }

    @Override
    public VeterinaryDTO getVeterinaryById(Long id) {

        VeterinaryEntity veterinary = veterinaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ApiMessage.VETERINARY_NOT_FOUND.getMessage()));

        return VeterinaryMapper.entityToDto(veterinary);
    }

    @Override
    public List<VeterinaryDTO> getAllVeterinary() {
        return veterinaryRepository.findAll()
                .stream().map(VeterinaryMapper::entityToDto)
                .toList();
    }

    @Override
    public String deleteVeterinary(Long id) {

        VeterinaryEntity veterinary = veterinaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ApiMessage.VETERINARY_NOT_FOUND.getMessage()));

        veterinaryRepository.delete(veterinary);

        return ApiMessage.SUCCESS_DELETE.getMessage();
    }

    @Override
    public VeterinaryDTO updateVeterinary(Long id, VeterinaryDTO veterinaryDTO) {
        return null;
    }
}

package com.veterinary_system.veterinary.controller;

import com.veterinary_system.common.dto.ApiResponse;
import com.veterinary_system.veterinary.dto.in.VeterinaryDTO;
import com.veterinary_system.veterinary.service.VeterinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/veterinary")
@RestController
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryService veterinaryService) {
        this.veterinaryService = veterinaryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<VeterinaryDTO>> createVeterinary(@RequestBody VeterinaryDTO veterinaryDTO) {

        ApiResponse<VeterinaryDTO> response = ApiResponse
                .<VeterinaryDTO>builder()
                .status(HttpStatus.CREATED.value())
                .message("Veterinaria creada con exito.")
                .data(veterinaryService.createVeterinary(veterinaryDTO))
                .build();


        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<VeterinaryDTO>> getVeterinary(@PathVariable Long id) {

        VeterinaryDTO veterinaryDTO = veterinaryService.getVeterinaryById(id);

        ApiResponse<VeterinaryDTO> response = ApiResponse
                .<VeterinaryDTO>builder()
                .message(veterinaryDTO != null ? "Veterinaria encontrada" : "")
                .status(HttpStatus.OK.value())
                .data(veterinaryDTO)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<List<VeterinaryDTO>>> getAllVeterinary() {

        List<VeterinaryDTO> veterinaries = veterinaryService.getAllVeterinary();

        ApiResponse<List<VeterinaryDTO>> response = ApiResponse
                .<List<VeterinaryDTO>>builder()
                .message(!veterinaries.isEmpty() ? "Veterinarias encontradas!" : "Aun no hay veterinarias registradas.")
                .status(HttpStatus.OK.value())
                .data(veterinaries)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteVeterinary(@PathVariable Long id) {

        ApiResponse<String> response = ApiResponse
                .<String>builder()
                .message(veterinaryService.deleteVeterinary(id))
                .status(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }
}

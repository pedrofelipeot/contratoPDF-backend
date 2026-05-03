package com.condominioPDF.contratoPDF.Controller;

import com.condominioPDF.contratoPDF.Entidade.Contrato;
import com.condominioPDF.contratoPDF.Service.ContratoPdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("download")
@RestController
@CrossOrigin("*")
public class ContratoPdfController {
    private final ContratoPdfService service;

    @PostMapping
    public ResponseEntity<byte[]> baixarPDF(@RequestBody Contrato contrato){
        byte[] pdf = service.criarPDF(contrato);

        return ResponseEntity.ok().header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename=contrato.pdf")
                .body(pdf);

    }

}

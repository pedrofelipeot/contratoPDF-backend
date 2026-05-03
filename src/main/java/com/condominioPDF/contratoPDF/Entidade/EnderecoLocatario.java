package com.condominioPDF.contratoPDF.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EnderecoLocatario {
    String rua;
    String numero;
    String cidade;
    String estado;
}

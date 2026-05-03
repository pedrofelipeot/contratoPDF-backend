package com.condominioPDF.contratoPDF.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Contrato {
    Locatario locatario;
    String apartamento;
    String meses;
    String data;
    String valor;
}

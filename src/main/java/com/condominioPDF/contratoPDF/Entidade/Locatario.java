package com.condominioPDF.contratoPDF.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Locatario {
    EnderecoLocatario endereco;

    String nome;
    String nacionalidade;
    String estadoCivil;
    String profissao;
    String cpf;
    String identidade;
}

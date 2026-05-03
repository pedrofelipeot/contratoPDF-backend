package com.condominioPDF.contratoPDF.Service;

import com.condominioPDF.contratoPDF.Entidade.Contrato;
import com.condominioPDF.contratoPDF.Entidade.EnderecoLocatario;
import com.condominioPDF.contratoPDF.Entidade.Locatario;
import com.itextpdf.html2pdf.HtmlConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ContratoPdfService {

    public byte[] criarPDF(Contrato contrato) {
        Path caminho = Paths.get("src/main/resources/contrato.html");
        byte[] pdfBytes = null;
        try {
            String html = Files.readString(caminho);

            html = html.replace("{nome}", contrato.getLocatario().getNome());
            html = html.replace("{nacionalidade}", contrato.getLocatario().getNacionalidade());
            html = html.replace("{estadoCivil}", contrato.getLocatario().getEstadoCivil());
            html = html.replace("{profissao}", contrato.getLocatario().getProfissao());
            html = html.replace("{cpf}", contrato.getLocatario().getCpf());
            html = html.replace("{identidade}", contrato.getLocatario().getIdentidade());
            html = html.replace("{rua}", contrato.getLocatario().getEndereco().getRua());
            html = html.replace("{numero}", contrato.getLocatario().getEndereco().getNumero());
            html = html.replace("{cidade}", contrato.getLocatario().getEndereco().getCidade());
            html = html.replace("{estado}", contrato.getLocatario().getEndereco().getEstado());
            html = html.replace("{apartamento}", contrato.getApartamento());
            html = html.replace("{meses}", contrato.getMeses());
            html = html.replace("{data}", contrato.getData());
            html = html.replace("{valor}", contrato.getValor());

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            HtmlConverter.convertToPdf(html, outputStream);
            pdfBytes = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfBytes;
    }

}

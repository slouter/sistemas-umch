package dev.umch.recursos.controlador.reporte;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dev.umch.recursos.entidad.Pais;
import dev.umch.recursos.repositorio.PaisRepositorio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.List;


@RestController
@RequestMapping("/api/reporte")
public class ReportePaisControlador {

    private final PaisRepositorio paisRepositorio;

    public ReportePaisControlador(PaisRepositorio paisRepositorio) {
        this.paisRepositorio = paisRepositorio;
    }

    @GetMapping("/paises")
    public ResponseEntity<byte[]> generarReportePaises() throws Exception {
        List<Pais> paises = paisRepositorio.findAll();

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);
        document.open();

        // Título
        Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
        Paragraph titulo = new Paragraph("REPORTE DE PAÍSES", fontTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Tabla con 2 columnas
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 4}); // ancho relativo de columnas
        table.setSpacingBefore(10f);

        // Encabezados
        Font headFont = new Font(Font.HELVETICA, 12, Font.BOLD);

        PdfPCell h1 = new PdfPCell(new Phrase("ID", headFont));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setBackgroundColor(Color.LIGHT_GRAY);
        h1.setPadding(5);
        table.addCell(h1);

        PdfPCell h2 = new PdfPCell(new Phrase("Nombre del País", headFont));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setBackgroundColor(Color.LIGHT_GRAY);
        h2.setPadding(5);
        table.addCell(h2);

        // Filas de datos
        for (Pais pais : paises) {
            PdfPCell c1 = new PdfPCell(new Phrase(String.valueOf(pais.getIdPais())));
            c1.setPadding(5);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase(pais.getNombrePais()));
            c2.setPadding(5);
            table.addCell(c2);
        }

        document.add(table);
        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "reporte-paises.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(baos.toByteArray());
    }



}

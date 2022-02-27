package br.com.inthurn.VilaDevInHouse.service.utilities;

import br.com.inthurn.VilaDevInHouse.model.report.VillageReport;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFManager {

    public static void generateReport(String documentName, VillageReport villageReport){
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(documentName + ".pdf"));

            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

            document.add(new Paragraph("Orçamento: " + villageReport.getBudget(), font));
            document.add(new Paragraph("Gasto Totais: " + villageReport.getTotalExpense(), font));
            document.add(new Paragraph("Diferença entre orçamento e gastos: "+ villageReport.getDiferenceBetweenBudgetAndExpense().toPlainString(), font));
            document.add(new Paragraph("Morador com a maior renda: ", font));
            document.add(new Paragraph("Nome: " + villageReport.getVillagerWithIncome().getName(), font));
            document.add(new Paragraph("Renda: " + villageReport.getVillagerWithIncome().getIncome(), font));
            document.add(new Paragraph("Identificador: " + villageReport.getVillagerWithIncome().getIdentifier(), font));
            document.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

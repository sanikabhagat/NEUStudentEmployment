package com.me.myprojectapp;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.me.myprojectapp.pojo.Application;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container

		doc.add(new Paragraph("Job Application PDF"));

		Application application = (Application) model.get("application");

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f });
		table.setSpacingBefore(30);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(20);

		// write table header
		//cell.setPhrase(new Phrase("Application ID", font));
		table.addCell(new Phrase("Application ID"));

		table.addCell(new Phrase(application.getApplicationid()));

		table.addCell(new Phrase("Job ID"));

		table.addCell(new Phrase(application.getJob().getJobid()));

		table.addCell(new Phrase("Job Title"));

		table.addCell(new Phrase(application.getJob().getJobtitle()));

		table.addCell(new Phrase("Employer"));

		table.addCell(new Phrase(application.getJob().getEmployer()));

		table.addCell(new Phrase("Wage"));

		table.addCell(new Phrase(application.getJob().getWage()));

		table.addCell(new Phrase("Grade Level"));

		table.addCell(new Phrase(application.getGrade()));

		table.addCell(new Phrase("Skills"));

		table.addCell(new Phrase(application.getSkills()));

		table.addCell(new Phrase("Experience"));

		table.addCell(new Phrase(application.getExperience()));

	

		doc.add(table);

	}
	
	
	

}
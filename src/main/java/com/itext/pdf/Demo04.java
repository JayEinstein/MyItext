package com.itext.pdf;

import java.io.File;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Demo04 {
	/*
	private void button16_Click(object sender, EventArgs e)
	{
	    Document doc = new Document(PageSize.A5);
	    PdfWriter.GetInstance(doc, File.Open(path, FileMode.Create));
	    doc.Open();
	    Paragraph paragraph1 = new Paragraph("This is first paragraph");
	    //居中显示
	    paragraph1.Alignment = Element.ALIGN_CENTER;
	    Paragraph paragraph2 = new Paragraph("This is second paragraph");
	    paragraph2.Alignment = Element.ALIGN_RIGHT;
	    //段落2与段落2的间距加大50个单位
	    paragraph2.SpacingAfter = 50;
	    //段落2与段落1的间距加大100个单位
	    paragraph2.SpacingBefore = 100;
	    Paragraph paragraph3 = new Paragraph("This is third paragraph,It's too long and show in new line");
	    //段落3距离左边100个单位显示
	    paragraph3.IndentationLeft = 100;
	    //段落3的第一行距离左边50个单位显示
	    paragraph3.FirstLineIndent = 50;
	    doc.Add(paragraph1);
	    doc.Add(paragraph2);
	    doc.Add(paragraph3);
	    doc.Close();
	}
	*/
}

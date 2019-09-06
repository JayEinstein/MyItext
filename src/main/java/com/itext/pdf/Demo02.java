package com.itext.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.PageSize;

public class Demo02 {

	public void 生成pdf文件() throws DocumentException, IOException {
		//Step 1—Create a Document.  
	    Document document = new Document();  
	    //Step 2—Get a PdfWriter instance.  
	    PdfWriter.getInstance(document, new FileOutputStream("resource/createSamplePDF.pdf"));
	    //Step 3—Open the Document.  
	    document.open();  
	    
		BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		Font FontChinese = new Font(bfChinese,12,Font.NORMAL);
		document.add(new Paragraph("你好",FontChinese));
		document.add(new Paragraph("等会我要说的事你们千万不要怕",FontChinese));
		document.add(new Paragraph("我们是警察我们不会怕",FontChinese));
		document.add(new Paragraph("电影有没有看",FontChinese));
		document.add(new Paragraph("雀骨丹道泰迪宝",FontChinese));
		//Step 4—Add content.  
		document.add(new Paragraph("Hello World 雀骨丹道 tomolou2"));  
		//Step 5—Close the Document.  
		document.close();
	}

	public void 插入图像() throws MalformedURLException, IOException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("createSamplePDF.pdf"));
		document.open();

		Image image = Image.getInstance("resource/aglie.png");
		float[] widths = { 1f, 4f };

		PdfPTable table = new PdfPTable(widths);

		Font font = new Font();
		// 插入图片
		table.addCell(new PdfPCell(new Paragraph("图片测试", font)));
		table.addCell(image);

		// 调整图片大小
		table.addCell("This two");
		table.addCell(new PdfPCell(image, true));

		// 不调整
		table.addCell("This three");
		table.addCell(new PdfPCell(image, false));
		document.add(table);
		document.close();
	}
	
	public void 生成模板() throws DocumentException, MalformedURLException, IOException {
		//创建文档,设置页面大小,      左、右、上和下页边距。
		Document document = new Document();
		document.setMargins(90f, 90f, 50f, 50f);
	    PdfWriter.getInstance(document, new FileOutputStream("resource/aglie.pdf"));
	    document.open();
	    	内容(document);
	    document.close();
	}
	
	private void 内容(Document document) throws MalformedURLException, IOException, DocumentException {
		Image backImg = Image.getInstance("resource/aglie.png");
	    backImg.scaleAbsolute(160f, 160f); // 设置图片大小 
	    backImg.setAbsolutePosition(90, 682); // 
	    backImg.setAlignment(Image.LEFT);
	    //图片填充方式
	    backImg.setAlignment(Image.TOP);
	    document.add(backImg);
	    
	    BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		Font Font12normal = new Font(bfChinese,12,Font.NORMAL);
		Font Font18bold = new Font(bfChinese, 18, Font.BOLD);
		
	    Paragraph title = new Paragraph("离职证明",Font18bold);
	    title.setAlignment(Element.ALIGN_CENTER);
	    title.setSpacingBefore(100f);
	    
	    Paragraph content = new Paragraph("  兹证明      （身份证号码：        ），于    年   月   日与我公司建立劳动关系并依法订立劳动合同，现任职     。现根据《劳动合同法》第 三十六 条的规定，因 用人单位提出与劳动者协商一致的 原因，于    年   月   日解除劳动合同。我公司已按法律规定支付经济补偿金，并已结清工资、所有假期、办理停保等相关法律手续。双方已经了结所有的劳动权利和义务，双方自愿放弃有关基于劳动关系产生的其它任何经济责任的追究权利。",Font12normal);
	    content.setSpacingBefore(24f);
	    content.setFirstLineIndent(24f); // 第一行间隔
//	    content.setSpacingAfter(100f);
	    
	    Paragraph second = new Paragraph("该证明书一式两份，当事人已于该证明书开出当天领取一份。",Font12normal);
	    second.setFirstLineIndent(24f);
	    
	    Paragraph tcsm = new Paragraph("特此证明。",Font12normal);
	    tcsm.setFirstLineIndent(24f);
	    
	    Paragraph company = new Paragraph("雅居乐地产置业有限公司",Font12normal);
	    company.setAlignment(Element.ALIGN_RIGHT);
	    company.setSpacingBefore(50f);
	    
	    Paragraph time = new Paragraph("二零一  年  月  日",Font12normal);
	    time.setAlignment(Element.ALIGN_RIGHT);
	    
	    document.add(title);
	    document.add(content);
	    document.add(second);
	    document.add(tcsm);
	    document.add(company);
	    document.add(time);
	}
}

package com.itext.pdf;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
 
/**
 * @author 刘毅
 * @date 2010-2-24
 * @ClassName WriteForPDF.java
 * @Email liu_yi126@163.com
 * @param 创建PDF
 * @param 
 */
 
/*
 * WriteForPDF
 	com.lowagie.text.Document 是生成 PDF 的主要的类。它是需要使用的第一个类。
  				一旦开始创建文档，将需要一个写入器向文档中写入内容。
 	com.lowagie.text.pdf.PdfWriter  就是一个 PDF 写入器。下面列出了通常需要使用的类：
　　com.lowagie.text.Paragraph —— 这个类表示一个缩进的段落。 
　　com.lowagie.text.Chapter —— 这个类表示 PDF 文档中的章节。使用 Paragraph 作为题目并使用 int 作为章节号码来创建它。
　　com.lowagie.text.Font —— 这个类包含了全部的字体规范，例如字体、大小、样式和颜色。各种字体都在这个类中声明为静态常数。 
　　com.lowagie.text.List —— 这个类表示一个列表，按顺序包含许多 ListItems。
　　com.lowagie.text.Table —— 这个类表示包含单元格的表，单元格有序地排列在矩阵中。
 */
public class Demo03 {
 /**
   *PDF文档、章节、小节、字体、段落、表格、列表的使用和中文的使用
   */
  public  void writePDF(String fileName) {
   File file = new File(fileName);
   FileOutputStream out = null;
   try {
    //创建文档,设置页面大小,      左、右、上和下页边距。
    Document document = new Document(PageSize.A4, 50, 50, 50, 50);
    //document是创建的文档,out是输出
    PdfWriter writer =PdfWriter.getInstance(document, new FileOutputStream(file));
    //设置加密的用户密码,所有者密码,可复制,可打印,加密位数
//    writer.setEncryption("1".getBytes(), "2".getBytes(), PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128); 
    //打开文档
    writer.setViewerPreferences(PdfWriter.PageModeUseOutlines);
    document.open();
    //-----------------------------------------------------------------------------------------
    
    //添加图片
    Image backImg = Image.getInstance("resource/aglie.png");
    backImg.scaleAbsolute(200f, 200f); // 设置图片大小 
    backImg.setAbsolutePosition(0, 642); // 
    backImg.setAlignment(Image.LEFT);
    //图片填充方式
    backImg.setAlignment(Image.TOP);
    document.add(backImg);
    
    //设置字体的大小,颜色,样式,FontFactory用于指定段落的字体.
    Font font = FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 255));
    Font font1 = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0));
    //设置段落标题并设置字体
    Paragraph chapterTitle = new Paragraph("Chapter 1",font);
    //创建了一个章节的对象，标题为"Chapter 1"
    Chapter chapter1 = new Chapter(chapterTitle,1);
    //设置为0,则在标题前面没有编号.反之...
    chapter1.setNumberDepth(0);
    //创建章节下的子章节.
    Paragraph sectionTitle = new Paragraph("Section 1 of Chapter 1", font1);
    //添加对象,属于chapter1。
    Section section1 = chapter1.addSection(sectionTitle);
    //写文本内容
    Paragraph text = new Paragraph("This is the first text in section 1 of chapter 1.");
    section1.add(text);
    text = new Paragraph("Following is a 5×5 table:");
    section1.add(text);
    //创建表格对象
    Table table = new Table(5, 5);
    //设置表格边框颜色
    table.setBorderColor(new Color(220, 255, 100));
    //边距
    table.setPadding(1);
    //间距
    table.setSpacing(1);
    table.setBorderWidth(1);
    //单元格对象
    Cell cell = null;
    //添加表头信息
    for (int colNum=0; colNum<5; colNum++){
     cell = new Cell("header-" + colNum);
     cell.setHeader(true);
     table.addCell(cell);
    }
    table.endHeaders();
    //添加表的内容
    for (int rowNum=1; rowNum<5; rowNum++){
     for (int colNum=0; colNum<5; colNum++){
      cell= new Cell("value-" + rowNum + "-" + colNum);
      table.addCell(cell);
     }
    }
    //将表格对象添加到对象中
    section1.add(table); 
    //添加列表
    // 列表包含一定数量的 ListItem。可以对列表进行编号，也可以不编号。
    // 将第一个参数设置为 true 表明想创建一个进行编号的列表；
    // 第二个参数设置为true表示列表采用字母进行编号，为false则用数字进行编号；
    // 第三个参数为列表内容与编号之间的距离。
    List list = new List(true, false, 20);
    ListItem item = new ListItem("First item of list;");
    list.add(item);
    item = new ListItem("Second item of list;");
    list.add(item);
    item = new ListItem("Third item of list.");
    list.add(item);
    //将列表对象添加到小节对象中
    section1.add(list);
    //simfang.ttf是仿宋的字体文件
    //中文,simfang.ttf是仿宋的字体文件
//    BaseFont bfChinese = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
    //中文大小为20，加粗
    font = new Font(bfChinese, 30, Font.BOLD);
    text = new Paragraph("PDF中文测试", font);
    section1.add(text);
    //加入到文档中
    document.add(chapter1);

    //关闭文档
    document.close();
    System.out.println("PDF文件生成成功，PDF文件名：" + file.getAbsolutePath());
   } catch (DocumentException e) {
    System.out.println("PDF文件"+ file.getAbsolutePath() + "生成失败！" + e);
    e.printStackTrace();
   } catch (IOException ee) {
    System.out.println("PDF文件"+ file.getAbsolutePath() + "生成失败！" + ee);
    ee.printStackTrace();
   } finally {
     try {
     if (out != null){
      //关闭输出文件流
      out.close();
     }
     } catch (IOException e1) {
    }
   }
  }
 
   
  public static void main(String[] args) {
   Demo03 pdf = new Demo03();
    String fileName = "resource/tempPDF.pdf";
    pdf.writePDF(fileName);
   }
}
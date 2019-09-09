package com.itext.pdf;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentException, MalformedURLException, IOException
    {
    	Demo02 d2 = new Demo02();
//    	d2.生成pdf文件();
//    	d2.插入图像();
    	d2.生成模板();
    }
    
    public void justF() {
    	// http://10.35.9.238:8082/ec-webservice/interface/esealServer
    	// 
    }
    
}

package com.read.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class FileToBase64 {
    /**
    * <p>将文件转成base64 字符串</p>
    * @param path 文件路径
    * @return
     * @throws IOException 
     * @throws Exception
    */
    public static String encodeBase64File(String path) throws IOException{
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }
    /**
    * <p>将base64字符解码保存文件</p>
    * @param base64Code
    * @param targetPath
     * @throws IOException 
    * @throws Exception
    */
    public static void decoderBase64File(String base64Code,String targetPath) throws IOException  {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    /**
    * <p>将base64字符保存文本文件</p>
    * @param base64Code
    * @param targetPath
    * @throws Exception
    */
    public static void toFile(String base64Code,String targetPath) throws Exception {
        byte[] buffer = base64Code.getBytes();
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
    public static void main(String[] args) {
        try {
            String base64Code =encodeBase64File("resource/aglie.pdf");
            System.out.println(base64Code);
            decoderBase64File(base64Code, "resource/aglie01.png");
            toFile(base64Code, "resource/aglie02.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
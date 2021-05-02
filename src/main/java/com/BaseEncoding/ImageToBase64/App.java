package com.BaseEncoding.ImageToBase64;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;



public class App 
{

    public static void main(String[] args) throws IOException {

        File f =  new File("converted/before.png");
          String base64String = encodeFileToBase64Binary(f);
          System.out.println(base64String);
          convertBase64StringToImage(base64String);
    }

    private static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile=Base64.getEncoder().encodeToString(bytes);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }finally {
        	 
         }

         return encodedfile;
     }
    
    private static void convertBase64StringToImage(String base64String) throws IOException {
    	
    	
    	 
    	        // this is not the real stream just for example
    	     
    	        // decode base64 encoded image
    	        BASE64Decoder decoder = new BASE64Decoder();
    	        byte[] decodedBytes = decoder.decodeBuffer(base64String);
    	       
    	           
    	         String uploadFile = "converted/test.png";
    	        
    	         // buffered image from the decoded bytes 
    	         BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
    	        
    	         File f = new File(uploadFile);
    	 
    	         // write the image
    	          ImageIO.write(image, "png", f);
    	      
    	
    	
    }

    
}

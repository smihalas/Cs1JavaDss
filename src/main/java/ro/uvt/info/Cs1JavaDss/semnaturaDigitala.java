/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.uvt.info.dsssc1;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

/**
 *
 * @author sm
 */
public class semnaturaDigitala {
    public static void main(String args[]) throws Exception {
      //Accepting text from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter some text");
      String msg = sc.nextLine();
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(1024);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();
      
      //Getting the private key from the key pair
      PrivateKey privKey = pair.getPrivate();
      
      //Creating a Signature object
      Signature sign = Signature.getInstance("SHA1withRSA");
      
      //Initialize the signature
      sign.initSign(privKey);
      byte[] bytes = "msg".getBytes();
      
      //Adding data to the signature
      sign.update(bytes);
      
      //Calculating the signature
      byte[] signature = sign.sign();
      int len = signature.length;
      
      StringBuilder hexBuilder = new StringBuilder();
        for (byte i: signature){
        hexBuilder.append(String.format("%02x ", i));
}
        String hexSignature = hexBuilder.toString();
      
      //Printing the signature
      //System.out.println("Digital signature of length = " + len + " for given text: "+new String(signature, "UTF8"));
      System.out.println("Digital signature of length = " + len + " for given text: " + hexSignature);
    } 
}

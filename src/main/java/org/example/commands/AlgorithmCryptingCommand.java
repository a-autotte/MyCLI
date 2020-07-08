package org.example.commands;


import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;

public class AlgorithmCryptingCommand implements ICommand {

    @Override
    public String GetCommandName() {
        return "al";
    }

    @Override
    public String GetCommandDescription() {
        return "Display the key of a plain text and convert it into a cipher text depend on the" +
                "algorithm you choosed";
    }

    @Override
    public void Execute(String[] args) {
        try {
            if (args[0].equals("") || args.length == 0)
            {
                throw new UnsupportedOperationException("You must enter an argument");
            }

            switch(args[0])
            {
                case "aes":
                    ConvertPlainTextToCipherAlgorithm("AES");
                    break;

                case "des":
                    ConvertPlainTextToCipherAlgorithm("DES");
                    break;
                case "md4":
                    ConvertPlainTextToCipherAlgorithm("MD4");
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("You must enter an argument to perform this action");
        }

    }

    private String ConvertPlainTextToCipherAlgorithm(String cipherAlgorithm)
    {
        Scanner plainTextToEnter = new Scanner(System.in);
        System.out.println("Enter the plain text :");
        String text = plainTextToEnter.nextLine();
        System.out.println("What is the key text :");
        String key = plainTextToEnter.nextLine();

        try {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(text.toCharArray(), key.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), cipherAlgorithm);

            Cipher cipher = Cipher.getInstance(cipherAlgorithm + "/CBC/PKCS5Padding");
            cipher.init(cipher.ENCRYPT_MODE, secretKey, ivspec);
            text = Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
            System.out.println("Cipher text : " + text);

            return text;

        } catch(Exception e)
        {
            System.out.println("Error while encrypting");
        }

        return null;


    }

    
}

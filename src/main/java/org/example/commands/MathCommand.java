package org.example.commands;

import java.awt.image.AffineTransformOp;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MathCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "math";
    }

    @Override
    public String GetCommandDescription() {
        return "This is a command used to perform mathematical operation <arg1> the format of your operation";
    }

    @Override
    public void Execute(String[] args) {
        if (args.length < 2)
        {
            throw new UnsupportedOperationException();
        }

        else
            {
                switch(args[0])
                {
                    case "bin":
                        ConvertDecimalIntoBase(args[1], 2);
                        break;

                    case "hex":
                        ConvertDecimalIntoBase(args[1], 16);
                        break;
                    case "ter":
                        ConvertDecimalIntoBase(args[1], 3);
                        break;
                    case "oct":
                        ConvertDecimalIntoBase(args[1], 8);
                        break;
                    case "duo":
                        ConvertDecimalIntoBase(args[1], 12);
                        break;

                }

            }
    }

    private void ConvertDecimalIntoBase(String numberToConvert1, int base)
    {
        int number = Integer.parseInt(numberToConvert1);
        int moduloNumber;
        ArrayList<String> baseNumber = new ArrayList<String> ();
        baseNumber.add("" + number % base);


        while (number / base != 0)
        {
            number = number / base;
            moduloNumber = number % base;
            baseNumber.add(Integer.toString(moduloNumber));
        }

        String trueBaseNumber = "";

        for (int index = baseNumber.size() - 1; index >= 0; index--)
        {
            trueBaseNumber += baseNumber.get(index);
        }


        System.out.println(trueBaseNumber);
    }

    private char NumberIntoHexChar(int number)
    {
        char numberIntoHexCode;
        switch(number)
        {

            case 10:
                numberIntoHexCode = 'A';
                break;
            case 11:
                numberIntoHexCode = 'B';
                break;
            case 12:
                numberIntoHexCode = 'C';
                break;
            case 13:
                numberIntoHexCode = 'D';
                break;
            case 14:
                numberIntoHexCode = 'E';
                break;
            case 15:
                numberIntoHexCode = 'F';
                break;
            default:
                numberIntoHexCode = (char)number;
        }

        return numberIntoHexCode;


    }
}
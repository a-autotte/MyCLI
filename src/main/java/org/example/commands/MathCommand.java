package org.example.commands;

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
                        ConvertDecimalToBin(args[1]);
                        break;
                }

            }
    }

    private void ConvertDecimalToBin(String numberToConvert)
    {
        int number = Integer.parseInt(numberToConvert);
        int moduloNumber;
        ArrayList<String> binNumber = new ArrayList<String> ();
        binNumber.add("" + number % 2);


        while (number / 2 != 0)
        {
            number = number / 2;
            moduloNumber = number % 2;
            binNumber.add(Integer.toString(moduloNumber));


        }

        String trueBinaryNumber = "";

        for (int index = binNumber.size() - 1; index >= 0; index--)
        {
            trueBinaryNumber += binNumber.get(index);
        }


        System.out.println(trueBinaryNumber);




    }
}
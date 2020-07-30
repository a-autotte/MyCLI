package org.example.commands;

public class AlgorithmCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "algo";
    }

    @Override
    public String GetCommandDescription() {
        return "Allow you to play with different types of algorithm such as sort, searching pattern, counting and much more";
    }

    @Override
    public void Execute(String[] args) {
        String[] sortArgs = new String[256];

        switch(args[0])
        {
            case "search":
                getIndexOfPattern(args[1], args[2]);
                break;

            case "sort":
                SortSequence(sortArgs);
                break;
        }
    }

    private static void getIndexOfPattern(String sequence, String pattern)
    {
        int M = pattern.length();
        int N = sequence.length();

        int[] lps = new int[M];

        int j = 0;

        ComputeLPSArray(pattern, M, lps);

        int i = 0;

        while(i < N)
        {
            if(pattern.charAt(j) == sequence.charAt(i))
            {
                j++;
                i++;
            }

            if (j == M)
            {
                System.out.println("Found index at : " + (i-j));
                j = lps[j - 1];
            }

            else if (i < N && pattern.charAt(j) != sequence.charAt(i))
            {
                if (j != 0)
                {
                    j = lps[j - 1];
                }

                else
                {
                    i++;
                }
            }
        }

    }

    private static void ComputeLPSArray(String pattern, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;


        while(i < M)
        {
            if (pattern.charAt(i) == pattern.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }

            else
            {
                if (len != 0)
                {
                    len = lps[len - 1];
                }

                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    private static void SortSequence(String[] args)
    {
        String finalString = "";

        for (int i = 0; i < args.length; i++)
        {
            int minValue = i;

            for (int j = i + 1; j < args.length; j++)
            {
                if (Integer.parseInt(args[j]) < Integer.parseInt(args[minValue]))
                {
                    minValue = j;
                }
            }

            String temp = args[minValue];
            args[minValue] = args[i];
            args[i] = temp;
            finalString += temp;
        }

        System.out.println(finalString);

    }
}

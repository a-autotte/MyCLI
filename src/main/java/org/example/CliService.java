package org.example;

import org.example.commands.*;

import java.util.*;
import java.util.Scanner;

public class CliService {
    private Map<String, ICommand> commands;
    private Scanner cliScanner;

    public CliService()
    {
        commands = new HashMap<>();
        cliScanner = new Scanner(System.in);
        InitService();
    }

    private void InitService()
    {
        commands.put("rep", new RepeatCommand());
        commands.put("math", new MathCommand());
        commands.put("ls", new ListCommand());
        commands.put("cd", new ChangeDirectoryCommand());
    }

    private void ExecuteCommand(String command, String[] args)
    {
        if (commands.containsKey(command))
        {
            ICommand selectedCommand = commands.get(command);
            System.out.println();
            selectedCommand.Execute(args);
            System.out.println();
        }

        else {
            throw new UnsupportedOperationException(String.format("The command is not valid", command));
        }
    }

    private void Welcome()
    {
        System.out.print("Welcome into my IOI Cli Experience");
    }

    private String UserInput()
    {
        System.out.println("Enter a command >");
        return cliScanner.nextLine();
    }

    private ParsedUserInput parsedInput(String input)
    {
        String[] validCommand = input.trim().split(" ");

        if (validCommand.length == 0 || validCommand[0].equals(""))
        {
            throw new UnsupportedOperationException("Enter a valid command");
        }

        String[] args;

        if (validCommand.length > 1)
        {
            args = Arrays.copyOfRange(validCommand, 1, validCommand.length);
        }

        else {
            args = new String[0];
        }

        return new ParsedUserInput(validCommand[0].toLowerCase(), args);
    }

    public void Run()
    {
        Welcome();
        while (true)
        {
            try {
                String input = UserInput();
                ParsedUserInput parseInput = parsedInput(input);
                ExecuteCommand(parseInput.command, parseInput.args);
            }

            catch(UnsupportedOperationException e)
            {
                System.out.print(e.getMessage());
            }
        }
    }
}

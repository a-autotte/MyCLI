package org.example.commands;


import java.io.Console;

public class ClearCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "clear";
    }

    @Override
    public String GetCommandDescription() {
        return "Clear the cli service terminal";
    }

    @Override
    public void Execute(String[] args) {

        for (int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }
}

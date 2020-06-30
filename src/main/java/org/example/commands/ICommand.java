package org.example.commands;

public interface ICommand {
    String GetCommandName();
    String GetCommandDescription();
    void Execute(String[] args);
}

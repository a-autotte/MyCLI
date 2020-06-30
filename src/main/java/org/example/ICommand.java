package org.example;



public interface ICommand {
    String GetCommandName();
    String GetCommandDescription();
    void Execute(String[] args);
}

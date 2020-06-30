package org.example;

public class ParsedUserInput {
    public String command;
    public String[] args;

    public ParsedUserInput(String Command, String[] Args)
    {
        this.command = Command;
        this.args = Args;
    }

}

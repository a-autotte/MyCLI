package org.example;

import java.util.HashMap;
import java.util.Map;

public class App
{


    public static void main(String[] args )
    {
        Map<String, ICommand> m_commands = new HashMap<>();
        m_commands.put("Math", new ICommand() { @Override public String GetCommandDescription() { return "It's a command where you can perform mathematical operation"; } @Override public String GetCommandName() { return "Math"; } @Override public void Execute(String[] args) { } });




    }
}

package org.example;

public class Command implements ICommand {
    private String m_commandName;
    private String m_commandDescription;
    private String[] m_args;

    public String GetCommandName()
    {
        return m_commandName;
    }

    public String GetCommandDescription()
    {
        return m_commandDescription;
    }

    public void Execute(String[] pArgs)
    {
        m_args = pArgs;
    }

    public Command(String pName, String pDescription, String[] pArgs)
    {
        m_commandName = pName;
        m_commandDescription = pDescription;
        m_args = pArgs;
    }


}

package org.example;

public abstract class Math implements ICommand {

    private String m_commandName;
    private String m_commandDescription;
    private String[] m_args;
    @Override
    public String GetCommandName() {
        return m_commandName;
    }

    @Override
    public String GetCommandDescription() {
        return m_commandDescription;
    }

    public void Execute(String[] pArgs)
    {
        m_args = pArgs;
    };

    public Math(String pCommandName, String pCommandDescription, String[] pArgs)
    {
        m_commandName = pCommandName;
        m_commandDescription = pCommandDescription;

    }
}

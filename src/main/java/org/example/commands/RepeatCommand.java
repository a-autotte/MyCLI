package org.example.commands;

public class RepeatCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "rep";
    }

    @Override
    public String GetCommandDescription() {
        return "This is a command used for repetition <args1> -> word to repeat <arg2> -> number of time you will" +
                "repeat the word";
    }

    @Override
    public void Execute(String[] args) {
        try {
            for (int time = 0; time < Integer.parseInt(args[1]); time++)
            {
                System.out.println(args[0]);
            }

        } catch(UnsupportedOperationException e)
        {
            System.out.println("The parameter you entered is not valid");
        }
    }
}

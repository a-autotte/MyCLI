package org.example.commands;

import java.io.File;

public class ChangeDirectoryCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "cd";
    }

    @Override
    public String GetCommandDescription() {
        return "Allow you to navigate through the directories drive";
    }

    @Override
    public void Execute(String[] args) {
        if (args[0].equals("") || args.length == 0)
        {
            throw new UnsupportedOperationException("Enter a valid command");
        }

        SetCurrentDirectory(args[0]);
    }

    private File SetCurrentDirectory(String destinationFolder)
    {
        File newDirectory;
        newDirectory = new File(destinationFolder).getAbsoluteFile();

        if (!newDirectory.exists() || !newDirectory.mkdirs())
        {
            throw new UnsupportedOperationException("The directory you entered is doesn't exist");
        }


        return newDirectory;
    }
}

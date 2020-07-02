package org.example.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ListCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "ls";
    }

    @Override
    public String GetCommandDescription() {
        return "Print the current files and folders of the current directory";
    }

    @Override
    public void Execute(String[] args) {
        switch(args[0])
        {
            case "dir":
                ListDirectoryContent();
                break;
            case "task":
                ListRunningProcess();
                break;
        }



    }

    private void ListDirectoryContent()
    {
        File fileFromCurDirectory = new File(System.getProperty("user.dir"));

        File[] listOfFile = fileFromCurDirectory.listFiles();

        for (File file : listOfFile)
        {
            if (file.isDirectory())
            {
                System.out.println("-------------------<DIR> \t\t" + file.getName());
            }

            else {
                System.out.println("------------------------ \t\t" + file.getName());
            }

        }
    }

    private void ListRunningProcess()
    {
        try {
            String process;

            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe /fo csv /nh");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((process = input.readLine()) != null)
            {
                System.out.println(process);
            }
            input.close();
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }



    }
}

package org.example.commands;

import java.net.Inet6Address;
import java.net.InetAddress;

public class NetworkCommand implements ICommand {
    @Override
    public String GetCommandName() {
        return "net";
    }

    @Override
    public String GetCommandDescription() {
        return "Display the configuration of your network";
    }

    @Override
    public void Execute(String[] args) {
        try {
            switch(args[0])
            {
                case "ip":
                    GetIpAddress(6);
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("You must enter one argument");
        }
    }

    private void GetIpAddress(int ipVersion)
    {
        try {
            switch(ipVersion)
            {
                case 4:
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    System.out.println("IPv4 address - " + InetAddress.getLocalHost());
                    break;

                case 6:
                    InetAddress inet6Address = Inet6Address.getLocalHost();
                    System.out.println("IPv6 address - " + inet6Address.getAddress());
                    break;
            }


        } catch(Exception e)
        {
            System.out.println("Couldn't find the IP address");
        }
    }





}

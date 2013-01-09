/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu
 * @author Daniel, Marco, Mak & Jonas
 */
public abstract class Menu
{

    protected int EXIT_OPTION = 0;
    private final String header;
    private final String[] menuItems;

    public Menu(String header, String... menuItems) //constructor
    {
        this.header = header;
        this.menuItems = menuItems;
    }

    public void run()       //runs and calls showMenu
    {
        boolean done = false;
        while (!done)
        {
            showMenu();
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION)
            {
                done = true;
            }
        }
    }

    private void showMenu()     //shows menu
    {
        clear();
        System.out.println();
        System.out.println(header.toUpperCase());
        System.out.println();

        for (int i = 0; i < menuItems.length; i++)
        {
            System.out.println(
                    String.format("%2d)  %s", (i + 1), menuItems[i]));
        }
        System.out.println(
                String.format("%2d)  %s", EXIT_OPTION, "Exit"));
    }

    private int getOption()
    {
        while (true)
        {
            try
            {
                System.out.print("\nEnter option: ");
                int option = new Scanner(System.in).nextInt();
                if (option >= 1 && option <= menuItems.length
                        || option == EXIT_OPTION)
                {
                    return option;
                }
                else
                {
                    System.out.println("\nERROR - Invalid option.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR - Not a number.");
            }
        }
    }
    
    protected void clear()      //clear by making 50 empty lines
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }
    
    protected void pause()      //pauses
    {
        System.out.println("\nPress ENTER to continue...");
        new Scanner(System.in).nextLine();
    }
    
     protected void printTeamHeader()            //Prints the Team header
    {
        System.out.println();
        System.out.println(String.format("%-5s %-20s %-20s %-30s %-30s",
                "ID", "School", "Captain", "Email", "Group"));
        System.out.println();
    }
    
    abstract protected void doAction(int option);
}

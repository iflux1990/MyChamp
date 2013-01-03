/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mak, Jonas, Daniel
 */
public abstract class Menu
{

    protected int EXIT_OPTION = 0;
    private final String header;
    private final String[] menuItems;

    /**
     *Constructor
     * @param header
     * @param menuItems
     */
    public Menu(String header, String... menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }

    /**
     *Starter menuen
     */
    public void run()
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
    /**
     * Viser menuen
     */
    private void showMenu()
    {
        clear();
        System.out.println();
        System.out.println(header);         //henter header og viser den
        System.out.println();

        for (int i = 0; i < menuItems.length; i++)
        {
            System.out.println(
                    String.format("%2d)  %s", (i + 1), menuItems[i]));
        }
        System.out.println(
                String.format("%2d)  %s", EXIT_OPTION, "Exit"));
    }
    /*
     * Går videre til menupunktet der indtastes
     */
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
    /*
     * Printer de forskellige sang headere
     */
    protected void printSongHeader()            //viser ID; Title, Artist... som overskrifter
    {
        System.out.println();
        System.out.println(String.format("%-5s %-30s %-30s %-10s %-20s %5s",
                "ID", "Title", "Artist", "Category", "Filename", "Duration"));
        System.out.println();
    }
    /**
     * Printer de forskellige playlist headere
     */
    protected void printPlaylistHeader() 
    {
        System.out.println();
        System.out.println(String.format("%-5s %-30s %-30s","ID","Name","Created"));
        System.out.println();
    }

    /**
     *Laver 50 tomme linjer
     */
    protected void clear()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    /**
     *Laver en pause
     */
    protected void pause()
    {
        System.out.println("\nPress ENTER to continue...");
        new Scanner(System.in).nextLine();
    }

    abstract protected void doAction(int option);
}

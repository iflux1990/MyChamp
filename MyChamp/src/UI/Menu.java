/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mak, Jonas, Daniel og Marco
 */
public abstract class Menu
{
    private int EXIT_OPTION;
 
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

    private void showMenu()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private int getOption()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void doAction(int option)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

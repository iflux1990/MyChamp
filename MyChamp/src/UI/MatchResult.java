/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Groggy
 */
public class MatchResult extends Menu
{

    private static final int EXIT_VALUE = 0;
 
    public MatchResult()
    {
        super("Match Result", "Record Result");
        EXIT_OPTION = EXIT_VALUE;
    }
    
    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                doActionSuboption1();
                break;
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Record Result");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

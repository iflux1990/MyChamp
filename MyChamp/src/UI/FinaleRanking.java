/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Groggy
 */
public class FinaleRanking extends Menu
{

    private static final int EXIT_VALUE = 0;
 
    public FinaleRanking()
    {
        super("Finale Ranking", "Finale Ranking");
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
        System.out.println("Finale Ranking");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 * The UI of the Finale Ranking
 * @author Daniel, Marco, Mak & Jonas
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
    /**
     * Printer at du har valgt finale ranking
     */
    private void doActionSuboption1()
    {
        System.out.println("Finale Ranking");        
    }
    /**
     * Printer exit besked
     */
    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

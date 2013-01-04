/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Groggy
 */
public class View extends Menu
{

    private static final int EXIT_VALUE = 0;
 
    public View()
    {
        super("View", "Total Match", "Group Match", "Team Match", "Finale Match");
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
            case 2:
                doActionSuboption2();
                break;
            case 3:
                doActionSuboption3();
                break;
            case 4:
                doActionSuboption4();
                break;
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Total match");
        pause();
    }
    
    private void doActionSuboption2()
    {
        System.out.println("Group match");
        pause();
    }
    
    private void doActionSuboption3()
    {
        System.out.println("Team match");
        pause();
    }
    
    private void doActionSuboption4()
    {
        System.out.println("Finale match");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

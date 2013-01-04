/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Groggy
 */
public class GroupRanking extends Menu
{

    private static final int EXIT_VALUE = 0;
 
    public GroupRanking()
    {
        super("Group Ranking", "Group", "Team");
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
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Group Ranking");
    }
    
    private void doActionSuboption2()
    {
        System.out.println("Team Ranking");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");

    }
}

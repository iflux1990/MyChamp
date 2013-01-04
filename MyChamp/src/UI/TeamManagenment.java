/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.TeamManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Groggy
 */
public class TeamManagenment extends Menu
{
    private static final int EXIT_VALUE = 0;
    private TeamManager tmgr = null;
    
    public TeamManagenment()
    {
        super("Team Managenment", "Add Team", "Update Team", "Remove Team");
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
                updateTeam();
                break;
            case 3:
                doActionSuboption3();
                break;
            case EXIT_VALUE: doActionExit();
        }
        try
        {
            tmgr = new TeamManager();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR - Could not find the Management layer.");
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Add Team");
        pause();
    }

    private void updateTeam()
    {
        new updateTeam().run();
    }
    
    private void doActionSuboption3()
    {
        System.out.println("Remove Team");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

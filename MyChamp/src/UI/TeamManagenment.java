/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Team;
import BLL.TeamManager;
import java.util.ArrayList;

/**
 *
 * @author Groggy
 */
public class TeamManagenment extends Menu
{
    private TeamManager tmgr;
    private static final int EXIT_VALUE = 0;
    
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
                doActionSuboption2();
                break;
            case 3:
                doActionSuboption3();
                break;
            case 4: 
                ListAll();
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Add Team");
    }

    private void doActionSuboption2()
    {
        System.out.println("Update Team");
    }
    
    private void doActionSuboption3()
    {
        System.out.println("Remove Team");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }

    private void ListAll()
    {
        try
        {
            ArrayList<Team> teams = tmgr.ListAllTeams();

            clear();
            

            for (Team t : teams)
            {
                System.out.println(t);
            }
        }
        catch (Exception e)
        {
            System.out.println(" ERROR - " + e.getMessage());

        }
        pause();
    }
}

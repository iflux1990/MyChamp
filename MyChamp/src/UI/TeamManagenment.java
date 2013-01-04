/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Team;
import BLL.TeamManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Groggy
 */
public class TeamManagenment extends Menu
{
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
                RemoveTeam();
                break;
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
    
    private void RemoveTeam()
    {
        clear();
        System.out.println("Remove team:");
        System.out.println("");
        try
        {

            ArrayList<Team> teams = tmgr.ListAll();


            printTeamHeader();
            for (Team t : teams)
            {
                System.out.println(t);
            }

            System.out.print("Select team by school: ");
            String school = new Scanner(System.in).nextLine();

            tmgr.RemoveTeam(school);
        }
        catch (Exception ex)
        {
            System.out.println(" ERROR - " + ex.getMessage());
            pause();
        }
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

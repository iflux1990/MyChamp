/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Team;
import BLL.TeamManager;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        super("Team Managenment", "Add Team", "Update Team", "Remove Team", "List All");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            tmgr = new TeamManager();
        }
        catch (Exception ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
            System.exit(2);
        }
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                AddTeam();
                break;
            case 2:
                updateTeam();
                break;
            case 3:
                RemoveTeam();
                break;
            case 4:
                ListAll();
                pause();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void AddTeam()
    {
        clear();

        System.out.println("Add Team");
        System.out.println();

        try
        {
            Scanner sc = new Scanner(System.in, "ISO-8859-1");

            System.out.print("School: ");
            String SchoolName = sc.nextLine();

            System.out.print("Team Captain: ");
            String Captain = sc.nextLine();

            System.out.print("Email: ");
            String TeamEmail = sc.nextLine();

            Team team = new Team(-1, SchoolName, Captain, TeamEmail);
            team = tmgr.addTeam(team);

            System.out.println();
            System.out.println("Song added with ID : " + team.getTeamId());
        }
        catch (InputMismatchException e)
        {
            System.out.println("ERROR - Duration must be number");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
//            System.out.println("ERROR - " + ex.getMessage());

        }
        pause();
    }

    private void updateTeam()
    {
        new updateTeam().run();
    }

    private void RemoveTeam()
    {
        ListAll();

        System.out.println("Remove team:");
        System.out.println("");
        try
        {
            System.out.print("Select team by school id: ");
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

    private void ListAll()
    {
        try
        {
            ArrayList<Team> teams = tmgr.ListAllTeams();

            clear();
            printTeamHeader();

            for (Team t : teams)
            {
                System.out.println(t);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
//            System.out.println(" ERROR - " + e.getMessage());

        }

    }
}

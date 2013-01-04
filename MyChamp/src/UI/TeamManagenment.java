/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Group;
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

    private static final int EXIT_VALUE = 0;
    private TeamManager tmgr;

    public TeamManagenment()
    {
        super("Team Managenment", "Add Team", "Update Team", "Remove Team");
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
                doActionSuboption3();
                break;
            case 4:
                ListAll();
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

            System.out.print("Team Captain: : ");
            String Captain = sc.nextLine();

            System.out.print("Email: ");
            String TeamEmail = sc.nextLine();


//            Artist a = amgr.getArtistByName(artistName);
//
//            if (a == null)
//            {
//                a = amgr.addArtist(new Artist(-1, artistName));
//            }
//
//            Category c = cmgr.getCategoryByName(categoryName);
//            if (c == null)
//            {
//                c = cmgr.addCategory(new Category(-1, categoryName));
//            }

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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Group;
import BE.Team;
import BLL.GroupManager;
import BLL.TeamManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
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
    private GroupManager gmgr;
    private static final int EXIT_VALUE = 0;

    public TeamManagenment()
    {
        super("Team Managenment", "Add Team", "Update Team", "Remove Team", "List All", "Sort Teams");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            tmgr = new TeamManager();
            gmgr = new GroupManager();
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
                UpdateTeams();
                break;
            case 3:
                RemoveTeam();
                break;
            case 4:
                ListAll();
                pause();
                break;
            case 5:
                sortTeams();
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
            
            System.out.println("Group is set to Unsorted group: ");
            int groupId = 5;
            
            Group g = gmgr.getGroupById(groupId);
            if (g == null)
            {
                System.out.println("fejl..");
            }

            Team team = new Team(-1, SchoolName, Captain, TeamEmail, g);
            team = tmgr.addTeam(team);

            System.out.println();
            System.out.println("Team added with ID : " + team.getTeamId());
        }
        
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR - " + ex.getMessage());
        }
        pause();
    }

    private void UpdateTeams()
    {
        clear();
        System.out.println("Update Team: ");
        System.out.println("");
        
        try
        {

            ArrayList<Team> teams = tmgr.ListAllTeams();


            printTeamHeader();
            for (Team t : teams)
            {
                System.out.println(t);
            }

            System.out.print("Select School Id: ");
            int id = new Scanner(System.in).nextInt();
            Team team = null;
            for (Team t : teams)
            {
                if (t.getTeamId() == id)
                {
                    team = t;
                }
            }
            if (team != null)
            {
                new UpdateTeams(team).run();
            }
            else
            {
                System.out.println("Unknown School Id");
                pause();
            }


        }
        catch (Exception e)
        {
//            System.out.println(" ERROR - " + e.getMessage());
            e.printStackTrace();

        }
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

            tmgr.removeTeam(school);
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

    private void sortTeams()
    {
        try
        {
            tmgr.sortTeams();
        }
        catch (SQLServerException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
        pause();
    }
}

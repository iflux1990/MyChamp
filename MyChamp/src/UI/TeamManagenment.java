/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Group;
import BE.Team;
import BLL.GroupManager;
import BLL.TeamManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu for the Team Managenment
 *
 * @author Daniel, Marco, Mak & Jonas
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
                AddTeam();      //add Teams
                break;
            case 2:
                UpdateTeams();  //updates Teams
                break;
            case 3:
                RemoveTeam();   //removes Team
                break;
            case 4:
                ListAll();      //list all Teams
                pause();
                break;
            case 5:
                sortTeams();    //sorts all Teams
                pause();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void AddTeam()      //Creates a new team
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

            System.out.println("ERROR - " + ex.getMessage());

        }
        pause();
    }

    private void UpdateTeams()  //List all Teams, Select Schhol id to edite
    {
        clear();
        System.out.println("Update Team(0 to abort): ");
        System.out.println("");

        try
        {

            ArrayList<Team> teams = tmgr.ListAllTeams();    //List all teams


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
            if (team == null)
            {
                return;
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

    private void RemoveTeam()   //Lister alle Teams, removes Team by School Id
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

    private void ListAll()  //Lister all Teams
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

//    private void sortTeams()
//    {
//        try
//        {
//            tmgr.assignGroups();
//        }
//        catch (SQLServerException ex)
//        {
//            System.out.println("ERROR - " + ex.getMessage());
//        }
//        catch (SQLException ex)
//        {
//            System.out.println("ERROR - " + ex.getMessage());
//        }
//        pause();
//    }
    private void sortTeams()    //Counts the number of teams in the tornument, 
    {                           //if below 12 the tornument cant start, the maxium of Teams are 16
        try
        {
            int counter = tmgr.showNumber();
            if (counter >= 12 && counter <= 16)
            {


                try
                {
                    tmgr.assignGroups();
                }
                catch (Exception e)
                {
                    System.out.println(" ERROR - " + e.getMessage());
                }
            }
            else if (counter < 12)  //minimum Teams to start the tornument
            {
                System.out.println("Too few teams to organize.");
            }
            else if (counter > 16) //maximum Teams in the tornument
            {
                System.out.println("Too many teams to organize.");
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR - " + e.getMessage());
        }

    }
}

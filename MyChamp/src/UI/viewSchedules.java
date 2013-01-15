/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Group;
import BE.Match;
import BLL.GroupManager;
import BLL.MatchManager;
import BLL.TeamManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mak
 */
public class viewSchedules extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
    private Match m;
    private Group g;
    private TeamManager tmgr;
    private GroupManager gmgr;

    public viewSchedules()
    {
        super("View Schedules",
                "Total Schedule",
                "Group Schedule",
                "Team Schedule",
                "Final Schedule");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            mmgr = new MatchManager();
            tmgr = new TeamManager();
            gmgr = new GroupManager();
        }
        catch (IOException | SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                totalSchedule();
                pause();
                break;
            case 2:
                groupSchedule();
                pause();
                break;
            case 3:
                teamSchedule();
                break;
            case 4:
                finalSchedule();
                break;
            case EXIT_VALUE:
                doActionExit();               
        }
    }

    private void totalSchedule()
    {
        try
        {
            System.out.println("Round 1: ");
            System.out.printf("%-5s%-20sVS%20s \n", "ID", "HomeTeam", "GuestTeam");
            ArrayList<Match> round1 = new ArrayList(mmgr.round1());
            for (int i = 0; i < round1.size(); i++)
            {
                if (round1.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round1.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round1.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round1.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round1.get(i).getGuestTeamId()).getSchoolName(), round1.get(i).getHomeGoals(), round1.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 2: ");
            ArrayList<Match> round2 = new ArrayList(mmgr.round2());
            for (int i = 0; i <= 7; i++)
            {
                if (round2.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round2.get(i).getId(), tmgr.getTeamById(round2.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round2.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round2.get(i).getId(), tmgr.getTeamById(round2.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round2.get(i).getGuestTeamId()).getSchoolName(), round2.get(i).getHomeGoals(), round2.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 3: ");
            ArrayList<Match> round3 = new ArrayList(mmgr.round3());
            for (int i = 0; i <= 7; i++)
            {
                if (round3.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round3.get(i).getId(), tmgr.getTeamById(round3.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round3.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round3.get(i).getId(), tmgr.getTeamById(round3.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round3.get(i).getGuestTeamId()).getSchoolName(), round3.get(i).getHomeGoals(), round3.get(i).getGuestGoals());
                }
            }

            System.out.println();
            System.out.println("Round 4: ");
            ArrayList<Match> round4 = new ArrayList(mmgr.round4());
            for (int i = 0; i <= 7; i++)
            {
                if (round4.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round4.get(i).getId(), tmgr.getTeamById(round4.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round4.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round4.get(i).getId(), tmgr.getTeamById(round4.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round4.get(i).getGuestTeamId()).getSchoolName(), round4.get(i).getHomeGoals(), round4.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 5: ");
            ArrayList<Match> round5 = new ArrayList(mmgr.round5());
            for (int i = 0; i <= 7; i++)
            {
                if (round5.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round5.get(i).getId(), tmgr.getTeamById(round5.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round5.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round5.get(i).getId(), tmgr.getTeamById(round5.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round5.get(i).getGuestTeamId()).getSchoolName(), round5.get(i).getHomeGoals(), round5.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 6: ");
            ArrayList<Match> round6 = new ArrayList(mmgr.round6());
            for (int i = 0; i <= 7; i++)
            {
                if (round6.get(i).isIsPlayed() == false)
                {
                    System.out.printf("%-5d%-20sVS%20s \n", round6.get(i).getId(), tmgr.getTeamById(round6.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round6.get(i).getGuestTeamId()).getSchoolName());
                }
                else
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round6.get(i).getId(), tmgr.getTeamById(round6.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round6.get(i).getGuestTeamId()).getSchoolName(), round6.get(i).getHomeGoals(), round6.get(i).getGuestGoals());
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }

    private void groupSchedule()
    {
        try
        {
            System.out.printf("%-10s%-5s \n", "Group ID", "Group Name");
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            for (int i = 0; i <= gmgr.listAllGroups().size() - 1; i++)
            {
                System.out.printf("%-10s%-5s \n", gmgr.listAllGroups().get(i).getGroupId(), gmgr.listAllGroups().get(i).getGroupName());
            }
            System.out.println("Select the group ID to view the group's schedule");
            int groupId = sc.nextInt();       
            
            
            ArrayList<Match> matches = mmgr.getMatchesInGroup(groupId);
            System.out.printf("%-5s %-20s VS %20s \n", "ID", "HomeTeam", "GuestTeam");
            System.out.println("");
            for(int i = 0; i < 12; i++)
            {
            System.out.printf("%-5d %-20s VS %20s \n",matches.get(i).getId(),tmgr.getTeamById(matches.get(i).getHomeTeamId()).getSchoolName(),tmgr.getTeamById(matches.get(i).getGuestTeamId()).getSchoolName());
            }
      
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }
    
    private void teamSchedule()
    {
          try
        {
            System.out.printf("%-10s%-5s \n", "Team ID", "School Name");
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            for (int i = 0; i <= tmgr.listAllTeams().size() - 1; i++)
            {
                System.out.printf("%-10s%-5s \n", tmgr.listAllTeams().get(i).getTeamId(),tmgr.listAllTeams().get(i).getSchoolName());
            }
            System.out.println("Select the Team ID to view the team's schedule");
            int teamId = sc.nextInt();       
            
            
            ArrayList<Match> matches = mmgr.getMatchesByTeam(teamId);
            System.out.printf("%-5s %-20s VS %20s \n", "ID", "HomeTeam", "GuestTeam");
            System.out.println("");
            for(int i = 0; i < matches.size(); i++)
            {
            System.out.printf("%-5d %-20s VS %20s \n",matches.get(i).getId(),tmgr.getTeamById(matches.get(i).getHomeTeamId()).getSchoolName(),tmgr.getTeamById(matches.get(i).getGuestTeamId()).getSchoolName());
            }
      
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }

    private void finalSchedule()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

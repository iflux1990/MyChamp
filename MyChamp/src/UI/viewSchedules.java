/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Match;
import BLL.MatchManager;
import BLL.TeamManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mak
 */
public class viewSchedules extends Menu
{

    private static final int EXIT_VALUE = 0;
     private MatchManager mmgr;
    private Match m;
    private TeamManager tmgr;

    public viewSchedules()
    {
        super("View Schedules",
                "Total Schedule",
                "Group Schedule",
                "Final Schedule");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            mmgr = new MatchManager();
            tmgr = new TeamManager();
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
                break;
            case 2:
                groupSchedule();
                break;
            case 3:
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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void finalSchedule()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void doActionExit()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class MatchManagement extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
    private Match m;
    private TeamManager tmgr;

    public MatchManagement()
    {
        super("Match Management",
                "Opening rounds",
                "Quarter finals",
                "Semi finales",
                "Final Match",
                "Schedule Matches",
                "Dummy",
                "Remove all Matches");
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
                viewOpeningRounds();
                pause();
                break;
            case 2:
                viewQuarterfinals();
                break;
            case 3:
                viewSemifinals();
                break;
            case 4:
                viewFinalMatch();
                pause();
                break;
            case 5:
                scheduleMatches();
                break;
            case 6:
                dummyMethod();
                pause();
                break;
            case 7:
                removeAllMatches();
                pause();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void scheduleMatches()
    {

        try
        {
            if (mmgr.NumberOfMatches() == 0)
            {
                mmgr.scheduleMatches();
                System.out.println(mmgr.NumberOfMatches() + " Have been added.");
            }
            else
            {
                System.out.println("You allready have scheduled matches");
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }

        pause();
    }

    private void removeAllMatches()
    {
        try
        {
            mmgr.removeAllMatches(m);
            tmgr.resetPoints();
        }
        catch (SQLException ex)
        {
            System.out.println("Matches have been removed and Match ID is reset to 0");
        }
    }

    public void viewOpeningRounds()
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
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }

    private void finalMatch()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void dummyMethod()
    {
        try
        {
            mmgr.scheduleQuaterFinals();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void viewQuarterfinals()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void viewSemifinals()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void viewFinalMatch()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

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
 * @author Daniel, Marco, Mak & Jonas
 */
public class View extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MatchManager mmgr;
    private Match m;
    private TeamManager tmgr;
 
    public View()
    {
        super("View", "Schedule Matches", "Remove all Matches", "View match Schedule", "Finale Match");
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
                scheduleMatches();
                pause();
                break;
            case 2:
                removeAllMatches();
                pause();
                break;
            case 3:
                viewSchedule();
                pause();
                break;
            case 4:
                doActionSuboption4();
                break;
                
            case EXIT_VALUE: doActionExit();
        }
    }

    private void scheduleMatches()
    {
        try
        {
            mmgr.scheduleMatches();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void removeAllMatches()
    {
         try
        {
            mmgr.removeAllMatches(m);
        }
        catch (SQLException ex)
        {
            System.out.println("Matches have been removed and Match ID is reset to 0");
        }
    }
    
    private void viewSchedule() 
    {
        try
        {
            
            System.out.println("Round 1: ");
            System.out.println("HomeTeam VS GuestTeam");
            ArrayList<Match> round1 = new ArrayList(mmgr.round1());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round1.get(i).getHomeTeamId()), tmgr.getTeamById(round1.get(i).getGuestTeamId()));
            }
            
            System.out.println("Round 2: ");
            ArrayList<Match> round2 = new ArrayList(mmgr.round2());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round2.get(i).getHomeTeamId()), tmgr.getTeamById(round2.get(i).getGuestTeamId()));
            }
            
            System.out.println("Round 3: ");
            ArrayList<Match> round3 = new ArrayList(mmgr.round3());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round3.get(i).getHomeTeamId()), tmgr.getTeamById(round3.get(i).getGuestTeamId()));
            }
            
            System.out.println("Round 4: ");
            ArrayList<Match> round4 = new ArrayList(mmgr.round4());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round4.get(i).getHomeTeamId()), tmgr.getTeamById(round4.get(i).getGuestTeamId()));
            }
            
                        System.out.println("Round 5: ");
            ArrayList<Match> round5 = new ArrayList(mmgr.round5());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round5.get(i).getHomeTeamId()), tmgr.getTeamById(round5.get(i).getGuestTeamId()));
            }
            
                        System.out.println("Round 6: ");
            ArrayList<Match> round6 = new ArrayList(mmgr.round6());
            for(int i = 0; i <= 7; i++)
            {
            System.out.printf("%-8s VS %4s \n", tmgr.getTeamById(round6.get(i).getHomeTeamId()), tmgr.getTeamById(round6.get(i).getGuestTeamId()));
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }
    
    private void doActionSuboption4()
    {
        System.out.println("Finale match");
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

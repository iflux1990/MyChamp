/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Match;
import BE.Team;
import BLL.MatchManager;
import BLL.TeamManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class MatchResult extends Menu
{

    private static final int EXIT_VALUE = 0;
    private final MatchManagement mmui;
    private MatchManager mmgr;
    private Match m;
    private Team t;
    private TeamManager tmgr;

    public MatchResult()
    {
        super("Match Result", "Record Result", "View Results");
        EXIT_OPTION = EXIT_VALUE;

        mmui = new MatchManagement();
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
                matchResult();
                break;
            case 2:
                viewResults();
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void matchResult()
    {
        try
        {
            mmui.viewOpeningRounds();


            Scanner sc = new Scanner(System.in, "ISO-8859-1");

            System.out.println("Match id or the two teams playing seperated by \":\" (HomeTeam:GuestTeam) :");
            if (sc.hasNextInt() == true)
            {
                int matchId = sc.nextInt();
                m = mmgr.getMatchById(matchId);
            }
            else
            {
                String matchteams = sc.nextLine();
                String[] ss = matchteams.split(":");
                
                Team team1 = tmgr.getTeamByName(ss[0]);
                Team team2 = tmgr.getTeamByName(ss[1]);
                
                m = mmgr.getMatchByTeams(team1.getTeamId(),team2.getTeamId());
            }
            
            System.out.println("Hometeam scored: ");
            int homeGoals = sc.nextInt();
            m.setHomeGoals(homeGoals);


            System.out.println("Guestteam scored: ");
            int guestGoals = sc.nextInt();
            m.setGuestGoals(guestGoals);





            if (homeGoals < guestGoals)
            {
                Team tguest = tmgr.getTeamById(m.getGuestTeamId());
                tguest.setPoints(3);
            }
            else if (homeGoals == guestGoals)
            {
                Team thome = tmgr.getTeamById(m.getHomeTeamId());
                Team tguest = tmgr.getTeamById(m.getGuestTeamId());
                tguest.setPoints(1);
                thome.setPoints(1);
            }
            else
            {
                Team thome = tmgr.getTeamById(m.getHomeTeamId());
                thome.setPoints(3);
            }
            m.setIsPlayed(true);
            mmgr.update(m);

//
//            if (m.getId() == matchId)
//            {
//                mmgr.update(m);
//            }
//            else
//            {
//                System.out.println("Match IDs did not fit.");
//            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
    }

    private void viewResults()
    {
        try
        {
            System.out.println("Round 1: ");
            System.out.printf("%-5s%-20sVS%20s%15s \n", "ID", "HomeTeam", "GuestTeam", "Goals");
            ArrayList<Match> round1 = new ArrayList(mmgr.round1());
            for (int i = 0; i < round1.size(); i++)
            {
                if (round1.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round1.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round1.get(i).getGuestTeamId()).getSchoolName(), round1.get(i).getHomeGoals(), round1.get(i).getGuestGoals());
                }

            }
            System.out.println();
            System.out.println("Round 2: ");
            ArrayList<Match> round2 = new ArrayList(mmgr.round2());
            for (int i = 0; i <= 7; i++)
            {
                if (round2.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round2.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round2.get(i).getGuestTeamId()).getSchoolName(), round2.get(i).getHomeGoals(), round2.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 3: ");
            ArrayList<Match> round3 = new ArrayList(mmgr.round3());
            for (int i = 0; i <= 7; i++)
            {
                if (round3.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round3.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round3.get(i).getGuestTeamId()).getSchoolName(), round3.get(i).getHomeGoals(), round3.get(i).getGuestGoals());
                }
            }

            System.out.println();
            System.out.println("Round 4: ");
            ArrayList<Match> round4 = new ArrayList(mmgr.round4());
            for (int i = 0; i <= 7; i++)
            {
                if (round4.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round4.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round4.get(i).getGuestTeamId()).getSchoolName(), round4.get(i).getHomeGoals(), round4.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 5: ");
            ArrayList<Match> round5 = new ArrayList(mmgr.round5());
            for (int i = 0; i <= 7; i++)
            {
                if (round5.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round5.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round5.get(i).getGuestTeamId()).getSchoolName(), round5.get(i).getHomeGoals(), round5.get(i).getGuestGoals());
                }
            }
            System.out.println();
            System.out.println("Round 6: ");
            ArrayList<Match> round6 = new ArrayList(mmgr.round6());
            for (int i = 0; i <= 7; i++)
            {
                if (round6.get(i).isIsPlayed() == true)
                {
                    System.out.printf("%-5d%-20sVS%20s%11d-%1d \n", round6.get(i).getId(), tmgr.getTeamById(round1.get(i).getHomeTeamId()).getSchoolName(), tmgr.getTeamById(round6.get(i).getGuestTeamId()).getSchoolName(), round6.get(i).getHomeGoals(), round6.get(i).getGuestGoals());
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
    }
}

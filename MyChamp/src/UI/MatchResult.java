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
        super("Match Result", "Record Result");
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

            System.out.println("Match id: ");
            int matchId = sc.nextInt();

            m = mmgr.getMatchById(matchId);


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

            if (m.getId() == matchId)
            {
                mmgr.update(m);
            }
            else
            {
                System.out.println("Match IDs did not fit.");
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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Match;
import BE.Team;
import DAL.TeamDBManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class MatchManager
{
    private TeamDBManager tdb;
    
    public void scheduleMatches() throws SQLException
    {
        //Round 1
        
        ArrayList<Team> group1 = tdb.listTeamsByGroupId(1);
        
        new Match(1, 1, group1[0][0], group1[1][0], isPlayed, homeGoals, guestGoals);
        new Match(2, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
        new Match(3, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
        new Match(4, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
        new Match(5, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
        new Match(6, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
        new Match(7, 1, homeTeamId, guestTeamId, isPlayed, homeGoals, guestGoals);
    }
    
}

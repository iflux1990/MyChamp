/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Match;
import BE.Team;
import DAL.TeamDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class MatchManager
{

    private TeamDBManager tdb;

    public MatchManager() throws IOException
    {
        tdb = new TeamDBManager();
    }

    public void scheduleMatches() throws SQLException
    {
        //Round 1

        ArrayList<Team> group1 = tdb.listTeamsByGroupId(1);

        for (int i = 0; i <= 3; i++)
        {
            for (int j = 0; j <= 3; i++)
            {
                System.out.println(group1.get(i).getSchoolName() + "vs" + group1.get(j).getSchoolName());
//                Match match = new Match(1, 1, group1.get(i).getTeamId(), group1.get(j).getTeamId());
            }
        }




    }
}

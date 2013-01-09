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

/**
 *
 * @author Daniel
 */
public class MatchManager
{

    private Match m;
    private TeamDBManager tdb;
    private Team t;

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
                {
                    for (int j = 0; j <= 3; j++)
                    {
                        if (group1.get(i) != group1.get(j))
                        {
//                      System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                            Match m = new Match(1, 1, group1.get(i).getTeamId(), group1.get(j).getTeamId());
                            String homeTeamName = tdb.getTeamById(m.getHomeTeamId());
                            String guestTeamName = tdb.getTeamById(m.getGuestTeamId());

                            System.out.println(homeTeamName + " vs " + guestTeamName);
                        }
                    }
                }
            }
            
            ArrayList<Team> group2 = tdb.listTeamsByGroupId(2);

            for (int i = 0; i <= 3; i++)
            {
                {
                    for (int j = 0; j <= 3; j++)
                    {
                        if (group2.get(i) != group2.get(j))
                        {
//                      System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                            Match m = new Match(1, 1, group2.get(i).getTeamId(), group2.get(j).getTeamId());
                            String homeTeamName = tdb.getTeamById(m.getHomeTeamId());
                            String guestTeamName = tdb.getTeamById(m.getGuestTeamId());

                            System.out.println(homeTeamName + " vs " + guestTeamName);
                        }
                    }
                }
            }
            
            ArrayList<Team> group3 = tdb.listTeamsByGroupId(3);

            for (int i = 0; i <= 3; i++)
            {
                {
                    for (int j = 0; j <= 3; j++)
                    {
                        if (group3.get(i) != group3.get(j))
                        {
//                      System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                            Match m = new Match(1, 1, group3.get(i).getTeamId(), group3.get(j).getTeamId());
                            String homeTeamName = tdb.getTeamById(m.getHomeTeamId());
                            String guestTeamName = tdb.getTeamById(m.getGuestTeamId());

                            System.out.println(homeTeamName + " vs " + guestTeamName);
                        }
                    }
                }
            }
            
            ArrayList<Team> group4 = tdb.listTeamsByGroupId(4);

            for (int i = 0; i <= 3; i++)
            {
                {
                    for (int j = 0; j <= 3; j++)
                    {
                        if (group4.get(i) != group4.get(j))
                        {
//                      System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                            Match m = new Match(1, 1, group4.get(i).getTeamId(), group4.get(j).getTeamId());
                            String homeTeamName = tdb.getTeamById(m.getHomeTeamId());
                            String guestTeamName = tdb.getTeamById(m.getGuestTeamId());

                            System.out.println(homeTeamName + " vs " + guestTeamName);
                        }
                    }
                }
            }









        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Match;
import BE.Team;
import DAL.MatchDBManager;
import DAL.TeamDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel, Marco, Mak & Jonas
 */
public class MatchManager
{

    private Match m;
    private Team t;
    private TeamDBManager tdb;
    private MatchDBManager mdb;
    private int numberPerTeam = 4;
    private int k = 0;

    public MatchManager() throws IOException
    {
        tdb = new TeamDBManager();
        mdb = new MatchDBManager();
    }

    public void scheduleMatches() throws SQLException
    {

        //Round 1


        ArrayList<Team> group1 = tdb.listTeamsByGroupId(1);
        ArrayList<Team> group2 = tdb.listTeamsByGroupId(2);
        ArrayList<Team> group3 = tdb.listTeamsByGroupId(3);
        ArrayList<Team> group4 = tdb.listTeamsByGroupId(4);
        if (group1.size() == 3)
        {
            numberPerTeam = 3;
        }

        if (group2.size() == 3)
        {
            numberPerTeam = 3;
        }

        if (group3.size() == 3)
        {
            numberPerTeam = 3;
        }

        if (group4.size() == 3)
        {
            numberPerTeam = 3;
        }


        for (int i = 0; i < numberPerTeam; i++)
        {
            {
                for (int j = 0; j < numberPerTeam; j++)
                {
                    if (group1.get(i) != group1.get(j))
                    {
//                      System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                        Match m1 = new Match(1, k, group1.get(i).getTeamId(), group1.get(j).getTeamId());
                        mdb.addMatches(m1);


                    }

                    if (group2.get(i) != group2.get(j))
                    {
//                           System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                        Match m2 = new Match(1, k, group2.get(i).getTeamId(), group2.get(j).getTeamId());
                        mdb.addMatches(m2);

                    }

                    if (group3.get(i) != group3.get(j))
                    {
//                          System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                        Match m3 = new Match(1, k, group3.get(i).getTeamId(), group3.get(j).getTeamId());
                        mdb.addMatches(m3);

                    }

                    if (group4.get(i) != group4.get(j))
                    {
//                            System.out.println(group1.get(i).getSchoolName() + " vs " + group1.get(j).getSchoolName());
                        Match m4 = new Match(1, k, group4.get(i).getTeamId(), group4.get(j).getTeamId());
                        mdb.addMatches(m4);
                    }
                }
            }
        }
    }
    
    public Match getMatchById(int Id) throws SQLException
    {
        return mdb.getMatchById(Id);
    }
            
}


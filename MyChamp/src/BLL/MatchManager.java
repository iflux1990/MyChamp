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
    
    public int NumberOfMatches() throws SQLException
    {
        return mdb.count();
    }
    
    public void update(Match m) throws SQLException
    {
        mdb.update(m);
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
                        Match m1 = new Match(1, -1, group1.get(i).getTeamId(), group1.get(j).getTeamId());
                        mdb.addMatches(m1);
                    }


                    if (group2.get(i) != group2.get(j))
                    {
                        Match m2 = new Match(1, -1, group2.get(i).getTeamId(), group2.get(j).getTeamId());
                        mdb.addMatches(m2);

                    }


                    if (group3.get(i) != group3.get(j))
                    {

                        Match m3 = new Match(1, -1, group3.get(i).getTeamId(), group3.get(j).getTeamId());
                        mdb.addMatches(m3);

                    }

                    if (group4.get(i) != group4.get(j))
                    {
                        Match m = new Match(1, -1, group4.get(i).getTeamId(), group4.get(j).getTeamId());
                        mdb.addMatches(m);
                    }

                }
            }

        }
    }

    public void removeAllMatches(Match m) throws SQLException
    {
        mdb.removeAllMatches(m);
    }

    public Match getMatchById(int Id) throws SQLException
    {
        return mdb.getMatchById(Id);
    }

    public ArrayList<Match> round1() throws SQLException
    {
        ArrayList<Match> round1 = new ArrayList();

        round1.add(mdb.getMatchById(1));
        round1.add(mdb.getMatchById(33));
        round1.add(mdb.getMatchById(2));
        round1.add(mdb.getMatchById(34));
        round1.add(mdb.getMatchById(3));
        round1.add(mdb.getMatchById(35));
        round1.add(mdb.getMatchById(4));
        round1.add(mdb.getMatchById(36));

        return round1;
    }

    public ArrayList<Match> round2() throws SQLException
    {
        ArrayList<Match> round2 = new ArrayList();
        round2.add(mdb.getMatchById(25));
        round2.add(mdb.getMatchById(41));
        round2.add(mdb.getMatchById(26));
        round2.add(mdb.getMatchById(42));
        round2.add(mdb.getMatchById(27));
        round2.add(mdb.getMatchById(43));
        round2.add(mdb.getMatchById(28));
        round2.add(mdb.getMatchById(44));

        return round2;
    }

    public ArrayList<Match> round3() throws SQLException
    {
        ArrayList<Match> round3 = new ArrayList();
        round3.add(mdb.getMatchById(13));
        round3.add(mdb.getMatchById(45));
        round3.add(mdb.getMatchById(14));
        round3.add(mdb.getMatchById(46));
        round3.add(mdb.getMatchById(15));
        round3.add(mdb.getMatchById(47));
        round3.add(mdb.getMatchById(16));
        round3.add(mdb.getMatchById(48));

        return round3;
    }

    public ArrayList<Match> round4() throws SQLException
    {
        ArrayList<Match> round4 = new ArrayList();
        round4.add(mdb.getMatchById(5));
        round4.add(mdb.getMatchById(21));
        round4.add(mdb.getMatchById(6));
        round4.add(mdb.getMatchById(22));
        round4.add(mdb.getMatchById(7));
        round4.add(mdb.getMatchById(23));
        round4.add(mdb.getMatchById(8));
        round4.add(mdb.getMatchById(24));

        return round4;
    }

    public ArrayList<Match> round5() throws SQLException
    {
        ArrayList<Match> round5 = new ArrayList();
        round5.add(mdb.getMatchById(17));
        round5.add(mdb.getMatchById(37));
        round5.add(mdb.getMatchById(18));
        round5.add(mdb.getMatchById(38));
        round5.add(mdb.getMatchById(19));
        round5.add(mdb.getMatchById(39));
        round5.add(mdb.getMatchById(20));
        round5.add(mdb.getMatchById(40));

        return round5;
    }
    
        public ArrayList<Match> round6() throws SQLException
    {
        ArrayList<Match> round6 = new ArrayList();
        round6.add(mdb.getMatchById(29));
        round6.add(mdb.getMatchById(9));
        round6.add(mdb.getMatchById(30));
        round6.add(mdb.getMatchById(10));
        round6.add(mdb.getMatchById(31));
        round6.add(mdb.getMatchById(11));
        round6.add(mdb.getMatchById(32));
        round6.add(mdb.getMatchById(12));

        return round6;
    }
}

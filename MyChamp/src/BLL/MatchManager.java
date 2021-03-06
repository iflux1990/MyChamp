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
/**
 * Henter count metoden fra DAL laget.
 * @return retunere en Int med antallet af kampe i databasen.
 * @throws SQLException 
 */
    public int NumberOfMatches() throws SQLException
    {
        return mdb.count();
    }

    /**
     * Henter update metoden fra DAL laget.
     * @param m bruger værdierne fra objektet "m" til at opdatere databasen
     * @throws SQLException smider SQLExceptions videre.
     */
    public void update(Match m) throws SQLException
    {
        mdb.update(m);
    }

    /**
     * Henter getMatchByTeams metoden fra databasen.
     * @param homeTeamId
     * @param guestTeamId
     * @return retuenere et enkelt match objekt med de to teams
     * @throws SQLException smider SQLExceptions videre
     */
    public Match getMatchByTeams(int homeTeamId, int guestTeamId) throws SQLException
    {
        return mdb.getMatchByTeams(homeTeamId, guestTeamId);
    }
/**
 * Henter alle teams fra databasen, en gruppe af gangen. laver en ny match hvis,
 * homeTeam ikke er magen til guestTeam og tilføjer den til databasen.
 * Laver alle matches for en gruppe af gangen.
 * @throws SQLException smider SQLExceptions videre.
 */
    
    public void scheduleMatches() throws SQLException
    {

        //Round 1
        ArrayList<Team> group1 = tdb.getTeamsByGroupId(1);
        ArrayList<Team> group2 = tdb.getTeamsByGroupId(2);
        ArrayList<Team> group3 = tdb.getTeamsByGroupId(3);
        ArrayList<Team> group4 = tdb.getTeamsByGroupId(4);
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
/**
 * Schedules the Quater final round
 * Laver 4 nye kampe, med 1. og 2 plads fra de indledende runder
 * @throws SQLException 
 */
    public void scheduleQuaterFinals() throws SQLException
    {
        Match quarterFinal1 = new Match(49, 7, tdb.getWinnerSecond(1).get(0).getTeamId(), tdb.getWinnerSecond(2).get(1).getTeamId());
        mdb.addMatches(quarterFinal1);
        Match quarterFinal2 = new Match(50, 7, tdb.getWinnerSecond(2).get(0).getTeamId(), tdb.getWinnerSecond(1).get(1).getTeamId());
        mdb.addMatches(quarterFinal2);
        Match quarterFinal3 = new Match(51, 7, tdb.getWinnerSecond(3).get(0).getTeamId(), tdb.getWinnerSecond(4).get(1).getTeamId());
        mdb.addMatches(quarterFinal3);
        Match quarterFinal4 = new Match(52, 7, tdb.getWinnerSecond(4).get(0).getTeamId(), tdb.getWinnerSecond(3).get(1).getTeamId());
        mdb.addMatches(quarterFinal4);
    }
  /**
   * Schedules the semi final round
   * Laver 2 nye kampe, med vinderne fra Quater finale
   * @throws SQLException 
   */  
    public void scheduleSemiFinals() throws SQLException
    {
        Match semiFinal1 = new Match(53, 8, tdb.getWinnerQuarter(49).getTeamId(), tdb.getWinnerQuarter(50).getTeamId());
        mdb.addMatches(semiFinal1);
        Match semiFinal2 = new Match(54, 8, tdb.getWinnerQuarter(51).getTeamId(), tdb.getWinnerQuarter(52).getTeamId());
        mdb.addMatches(semiFinal2);        
    }

   /**
    * Henter funktionen Remove all matches fra MatchDBManager
    * @throws SQLException 
    */
    public void removeAllMatches() throws SQLException
    {
        mdb.removeAllMatches();
    }

    /**
     * Henter funktionen get match by ID fra MatchDBManager
     * @param Id
     * @return match by ID
     * @throws SQLException 
     */
    public Match getMatchById(int Id) throws SQLException
    {
        return mdb.getMatchById(Id);
    }
    
    public ArrayList<Match> getMatchesInGroup(int groupId) throws SQLException
    {
        return mdb.getMatchesInGroup(groupId);
    }
    
    public ArrayList<Match> getMatchesByTeam(int teamId) throws SQLException
    {
        return mdb.getMatchesByTeam(teamId);
    }

    /**
     * Laver Round 1, ud fra Match ID
     * @return
     * @throws SQLException 
     */
    public ArrayList<Match> round1() throws SQLException
    {
        ArrayList<Match> round1 = new ArrayList();

        round1.add(mdb.getMatchById(29));
        round1.add(mdb.getMatchById(9));
        round1.add(mdb.getMatchById(30));
        round1.add(mdb.getMatchById(10));
        round1.add(mdb.getMatchById(31));
        round1.add(mdb.getMatchById(11));
        round1.add(mdb.getMatchById(32));
        round1.add(mdb.getMatchById(12));

        return round1;
    }
    /**
     * Laver Round 2, ud fra Match ID
     * @return
     * @throws SQLException 
     */
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
     /**
     * Laver Round 3, ud fra Match ID
     * @return
     * @throws SQLException 
     */
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
    /**
     * Laver Round 4, ud fra Match ID
     * @return
     * @throws SQLException 
     */
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
    /**
     * Laver Round 5, ud fra Match ID
     * @return
     * @throws SQLException 
     */
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
    /**
     * Laver Round 6, ud fra Match ID
     * @return
     * @throws SQLException 
     */
    public ArrayList<Match> round6() throws SQLException
    {
        ArrayList<Match> round6 = new ArrayList();
        round6.add(mdb.getMatchById(1));
        round6.add(mdb.getMatchById(33));
        round6.add(mdb.getMatchById(2));
        round6.add(mdb.getMatchById(34));
        round6.add(mdb.getMatchById(3));
        round6.add(mdb.getMatchById(35));
        round6.add(mdb.getMatchById(4));
        round6.add(mdb.getMatchById(36));

        return round6;
    }
    /**
     * Updater match rounds
     * @throws SQLException 
     */
    public void updateMatchRounds() throws SQLException
    {
        for (int i = 0; i < 8; i++)
        {
            ArrayList<Match> matches1 = round1();
            
            matches1.get(i).setMatchRound(1);
            mdb.update(matches1.get(i));
            System.out.print("--");
            
            ArrayList<Match> matches2= round2();
            
            matches2.get(i).setMatchRound(2);
            mdb.update(matches2.get(i));
            
            ArrayList<Match> matches3 = round3();
            
            matches3.get(i).setMatchRound(3);
            mdb.update(matches3.get(i));
            
            ArrayList<Match> matches4 = round4();
            
            matches4.get(i).setMatchRound(4);
            mdb.update(matches4.get(i));
            
            ArrayList<Match> matches5 = round5();
            
            matches5.get(i).setMatchRound(5);
            mdb.update(matches5.get(i));
            
            ArrayList<Match> matches6 = round6();
            
            matches6.get(i).setMatchRound(6);
            mdb.update(matches6.get(i));
        }
    }
}

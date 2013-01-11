/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import DAL.TeamDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Business entity of the Match table
 * @author Daniel, Marco, Mak & Jonas
 */
public class Match
{
    private final int Id;
    private int matchRound;
    private final int homeTeamId;
    private final int guestTeamId;
    private boolean isPlayed;
    private int homeGoals;
    private int guestGoals;
    private String homeTeam;
    private String guestTeam;
    private TeamDBManager tdb;
    
    
    /**
     * Constructor for the Match object
     * @param Id
     * @param matchRound
     * @param homeTeamId
     * @param guestTeamId
     * @param isPlayed
     * @param homeGoals
     * @param guestGoals
     */
    public Match(int Id, int matchRound, int homeTeamId, int guestTeamId, boolean isPlayed, int homeGoals, int guestGoals)
    {
        this.Id = Id;
        this.matchRound = matchRound;
        this.homeTeamId = homeTeamId;
        this.guestTeamId = guestTeamId;
        this.isPlayed = isPlayed;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
        
    }
    
    /**
     * Constructor for the Match object
     * @param Id
     * @param matchRound
     * @param homeTeamId
     * @param guestTeamId
     */
    public Match(int Id, int matchRound, int homeTeamId, int guestTeamId)
    {
        this(Id, matchRound, homeTeamId, guestTeamId, false, -1, -1);
    }
    
    /**
     * 
     * @param Id
     * @param m
     */
    public Match(int Id, Match m)
    {
        this(Id, m.getMatchRound(), m.getHomeTeamId(), m.getGuestTeamId(), m.getIsPlayed(), m.getHomeGoals(), m.getGuestGoals());
    }

    /**
     * @return the Id
     */
    public int getId()
    {
        return Id;
    }
    
    
    /**
     * @return the MatchRound
     */
    public int getMatchRound()
    {
        return matchRound;
    }

    /**
     * @param matchRound the MatchRound to set
     */
    public void setMatchRound(int matchRound)
    {
        this.matchRound = matchRound;
    }

    /**
     * @return the HomeTeamId
     */
    public int getHomeTeamId()
    {
        return homeTeamId;
    }

    /**
     * @return the GuestTeamId
     */
    public int getGuestTeamId()
    {
        return guestTeamId;
    }

    /**
     * @return the isPlayed
     */
    public boolean getIsPlayed()
    {
        return false;       
    }

    /**
     * @param isPlayed the isPlayed to set
     */
    public void setIsPlayed(boolean isPlayed)
    {
       isPlayed = true;  
    }

    /**
     * @return the HomeGoals
     */
    public int getHomeGoals()
    {
        return homeGoals;
    }

    /**
     * @param homeGoals the HomeGoals to set
     */
    public void setHomeGoals(int homeGoals)
    {
        this.homeGoals = homeGoals;
    }

    /**
     * @return the GuestGoals
     */
    public int getGuestGoals()
    {
        return guestGoals;
    }

    /**
     * @param guestGoals the GuestGoals to set
     */
    public void setGuestGoals(int guestGoals)
    {
        this.guestGoals = guestGoals;
    }
    
    @Override
    public String toString()
    {
        
        try
        {
            tdb = new TeamDBManager();
            return String.format("%-5d%-20sVS%20s \n", getId(), tdb.getTeamById(homeTeamId).getSchoolName(), tdb.getTeamById(guestTeamId).getSchoolName());
        }
        catch (SQLException | IOException ex)
        {
            System.out.println("ERROR - "+ ex.getMessage());
        }
        return null;
    }
    
}

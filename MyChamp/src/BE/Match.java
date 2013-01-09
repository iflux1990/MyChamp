/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 * The Business entity of the Match table
 * @author Daniel, Marco, Mak & Jonas
 */
public class Match
{
    private final int Id;
    private int MatchRound;
    private final int HomeTeamId;
    private final int GuestTeamId;
    private int isPlayed;
    private int HomeGoals;
    private int GuestGoals;
    
    
    public Match(int Id, int MatchRound, int HomeTeamId, int GuestTeamId, int isPlayed, int HomeGoals, int GuestGoals)
    {
        this.Id = Id;
        this.MatchRound = MatchRound;
        this.HomeTeamId = HomeTeamId;
        this.GuestTeamId = GuestTeamId;
        this.isPlayed = isPlayed;
        this.HomeGoals = HomeGoals;
        this.GuestGoals = GuestGoals;
        
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
        return MatchRound;
    }

    /**
     * @param MatchRound the MatchRound to set
     */
    public void setMatchRound(int MatchRound)
    {
        this.MatchRound = MatchRound;
    }

    /**
     * @return the HomeTeamId
     */
    public int getHomeTeamId()
    {
        return HomeTeamId;
    }

    /**
     * @return the GuestTeamId
     */
    public int getGuestTeamId()
    {
        return GuestTeamId;
    }

    /**
     * @return the isPlayed
     */
    public int getIsPlayed()
    {
        return isPlayed;
    }

    /**
     * @param isPlayed the isPlayed to set
     */
    public void setIsPlayed(int isPlayed)
    {
        this.isPlayed = isPlayed;
    }

    /**
     * @return the HomeGoals
     */
    public int getHomeGoals()
    {
        return HomeGoals;
    }

    /**
     * @param HomeGoals the HomeGoals to set
     */
    public void setHomeGoals(int HomeGoals)
    {
        this.HomeGoals = HomeGoals;
    }

    /**
     * @return the GuestGoals
     */
    public int getGuestGoals()
    {
        return GuestGoals;
    }

    /**
     * @param GuestGoals the GuestGoals to set
     */
    public void setGuestGoals(int GuestGoals)
    {
        this.GuestGoals = GuestGoals;
    }
    
}

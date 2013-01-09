/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniel
 */
public class Match
{
    private final int Id;
    private int matchRound;
    private final int homeTeamId;
    private final int guestTeamId;
    private int isPlayed;
    private int homeGoals;
    private int guestGoals;
    private String homeTeam;
    private String guestTeam;
    
    
    public Match(int Id, int MatchRound, int HomeTeamId, int GuestTeamId, int isPlayed, int HomeGoals, int GuestGoals)
    {
        this.Id = Id;
        this.matchRound = MatchRound;
        this.homeTeamId = HomeTeamId;
        this.guestTeamId = GuestTeamId;
        this.isPlayed = isPlayed;
        this.homeGoals = HomeGoals;
        this.guestGoals = GuestGoals;
        
    }
    
    public Match(int Id, int MatchRound, int HomeTeamId, int GuestTeamId)
    {
        this(Id, MatchRound, HomeTeamId, GuestTeamId, -1, -1, -1);
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
     * @param MatchRound the MatchRound to set
     */
    public void setMatchRound(int MatchRound)
    {
        this.matchRound = MatchRound;
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
        return homeGoals;
    }

    /**
     * @param HomeGoals the HomeGoals to set
     */
    public void setHomeGoals(int HomeGoals)
    {
        this.homeGoals = HomeGoals;
    }

    /**
     * @return the GuestGoals
     */
    public int getGuestGoals()
    {
        return guestGoals;
    }

    /**
     * @param GuestGoals the GuestGoals to set
     */
    public void setGuestGoals(int GuestGoals)
    {
        this.guestGoals = GuestGoals;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-5d %-10d %-10d", Id, homeTeamId, guestTeamId );
    }
    
}

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
    private int matchRound;
    private final int homeTeamId;
    private final int guestTeamId;
    private boolean isPlayed;
    private int homeGoals;
    private int guestGoals;
    private String homeTeam;
    private String guestTeam;
    
    
    public Match(int Id, int MatchRound, int HomeTeamId, int GuestTeamId, boolean isPlayed, int HomeGoals, int GuestGoals)
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
        this(Id, MatchRound, HomeTeamId, GuestTeamId, false, -1, -1);
    }
    
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

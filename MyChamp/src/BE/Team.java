/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 * The Business entity of the Team table
 * @author Daniel, Marco, Mak & Jonas
 */
public class Team
{

    private final int teamId;
    private String schoolName;
    private String captain;
    private String teamEmail;
    private Group group;
    private int groupId;
    private int points = 0;

    /**
     * Constructor for the Team object
     * @param teamId
     * @param schoolName
     * @param captain
     * @param teamEmail
     * @param group
     */
    public Team(int teamId, String schoolName, String captain, String teamEmail, Group group, int points)
    {
        this.teamId = teamId;
        this.schoolName = schoolName;
        this.captain = captain;
        this.teamEmail = teamEmail;
        this.group = group;
        this.points = points;
        
    }    
    
    public Team(int teamId, String schoolName, String captain, String teamEmail, Group group) //Constructor
    {
        this.teamId = teamId;
        this.schoolName = schoolName;
        this.captain = captain;
        this.teamEmail = teamEmail;
        this.group = group;
    }

    /**
     * Constructor for the Team object
     * @param teamId
     * @param t
     */
    public Team(int teamId, Team t)
    {
        this(teamId, t.getSchoolName(), t.getCaptain(), t.getTeamEmail(), t.getGroup());
    }
    
   
    public Team(int TeamId, String SchoolName, String Captain, String TeamEmail)
    {
        this.teamId = TeamId;
        this.schoolName = SchoolName;
        this.captain = Captain;
        this.teamEmail = TeamEmail;
        
    }
    /**
     * @return the TeamId
     */
    public int getTeamId()
    {
        return teamId;
    }

    /**
     * @return the SchoolName
     */
    public String getSchoolName()
    {
        return schoolName;
    }

    /**
     * @param schoolName the SchoolName to set
     */
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    /**
     * @return the Captain
     */
    public String getCaptain()
    {
        return captain;
    }

    /**
     * @param captain the Captain to set
     */
    public void setCaptain(String captain)
    {
        this.captain = captain;
    }

    /**
     * @return the TeamEmail
     */
    public String getTeamEmail()
    {
        return teamEmail;
    }

    /**
     * @param teamEmail the TeamEmail to set
     */
    public void setTeamEmail(String teamEmail)
    {
        this.teamEmail = teamEmail;
    }

    /**
     * @return the GroupId
     */
    public int getGroupId()
    {
        return groupId;
    }
    /**
     * @return the group
     */
    public Group getGroup()
    {
        return group;
    }
    /**
     * @param GroupId the GroupId to set
     */
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
    
    public void addPoints(int p)
    {
        this.points = points + p;
    }
    public void setPoints(int p)
    {
        points += p;
    }

    @Override
    public String toString()
    {
        return String.format("%-5d %-20s %-20s %-29s %-29s", teamId, schoolName, captain, teamEmail, group);
    }

    public int getPoints()
    {
        return points;
    }
}

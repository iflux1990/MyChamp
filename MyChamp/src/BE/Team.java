/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniel
 */
public class Team
{

    private final int teamId;
    private String schoolName;
    private String captain;
    private String teamEmail;
    private Group group;
//    private int GroupId;
    private int groupId;

    public Team(int TeamId, String SchoolName, String Captain, String TeamEmail, Group group)
    {
        this.teamId = TeamId;
        this.schoolName = SchoolName;
        this.captain = Captain;
        this.teamEmail = TeamEmail;
        this.group = group;
    }

    public Team(int TeamId, Team t)
    {
        this(TeamId, t.getSchoolName(), t.getCaptain(), t.getTeamEmail(), t.getGroup());
    }

//    
//    public Team(int TeamId, String SchoolName, String Captain, String TeamEmail)
//    {
//        this.TeamId = TeamId;
//        this.SchoolName = SchoolName;
//        this.Captain = Captain;
//        this.TeamEmail = TeamEmail;
//        
//    }
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
     * @param SchoolName the SchoolName to set
     */
    public void setSchoolName(String SchoolName)
    {
        this.schoolName = SchoolName;
    }

    /**
     * @return the Captain
     */
    public String getCaptain()
    {
        return captain;
    }

    /**
     * @param Captain the Captain to set
     */
    public void setCaptain(String Captain)
    {
        this.captain = Captain;
    }

    /**
     * @return the TeamEmail
     */
    public String getTeamEmail()
    {
        return teamEmail;
    }

    /**
     * @param TeamEmail the TeamEmail to set
     */
    public void setTeamEmail(String TeamEmail)
    {
        this.teamEmail = TeamEmail;
    }

    /**
     * @return the GroupId
     */
    public int getGroupId()
    {
        return groupId;
    }

    public Group getGroup()
    {
        return group;
    }

    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }

    @Override
    public String toString()
    {
        return String.format("%-5d %-20s %-20s %-30s %-20s", teamId, schoolName, captain, teamEmail, group);
    }
}

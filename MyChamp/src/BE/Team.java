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
    private final int TeamId;
    private String SchoolName;
    private String Captain;
    private String TeamEmail;
    private final int GroupId;
    
    
    public Team(int TeamId, String SchoolName, String Captain, String TeamEmail, int GroupId)
    {
        this.TeamId = TeamId;
        this.SchoolName = SchoolName;
        this.Captain = Captain;
        this.TeamEmail = TeamEmail;
        this.GroupId = GroupId;
        
    }

    /**
     * @return the TeamId
     */
    public int getTeamId()
    {
        return TeamId;
    }

    /**
     * @return the SchoolName
     */
    public String getSchoolName()
    {
        return SchoolName;
    }

    /**
     * @param SchoolName the SchoolName to set
     */
    public void setSchoolName(String SchoolName)
    {
        this.SchoolName = SchoolName;
    }

    /**
     * @return the Captain
     */
    public String getCaptain()
    {
        return Captain;
    }

    /**
     * @param Captain the Captain to set
     */
    public void setCaptain(String Captain)
    {
        this.Captain = Captain;
    }

    /**
     * @return the TeamEmail
     */
    public String getTeamEmail()
    {
        return TeamEmail;
    }

    /**
     * @param TeamEmail the TeamEmail to set
     */
    public void setTeamEmail(String TeamEmail)
    {
        this.TeamEmail = TeamEmail;
    }

    /**
     * @return the GroupId
     */
    public int getGroupId()
    {
        return GroupId;
    }
}

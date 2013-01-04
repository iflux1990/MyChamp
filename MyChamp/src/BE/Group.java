/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniel
 */
public class Group
{
    private final int GroupId;
    private String GroupName;
    
    public Group(int GroupId, String GroupName)
    {
        this.GroupId = GroupId;
        this.GroupName = GroupName;
        
    }
    
    public Group(int GroupId)
    {
        this.GroupId = GroupId;
    }        
            

    /**
     * @return the GroupId
     */
    public int getGroupId()
    {
        return GroupId;
    }

    /**
     * @return the GroupName
     */
    public String getGroupName()
    {
        return GroupName;
    }

    /**
     * @param GroupName the GroupName to set
     */
    public void setGroupName(String GroupName)
    {
        this.GroupName = GroupName;
    }
}

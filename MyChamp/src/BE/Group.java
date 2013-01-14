/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 * The Business entity of the Group table
 * @author Daniel, Marco, Mak & Jonas
 */
public class Group
{

    private int groupId;
    private String groupName;

    /**
     * Constructor for the Group object
     * @param groupId
     * @param groupName
     */
    public Group(int groupId, String groupName) 
    {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /**
     * Constructor for the Group object
     * @param groupName
     */
    public Group(String groupName)
    {
        this(-1, groupName);

    }

    /**
     * Constructor for the Group object
     * @param groupId
     */
    public Group(int groupId)
    {
        this.groupId = groupId;
    }

    /**
     * @return the GroupId
     */
    public int getGroupId()
    {
        return groupId;
    }

    /**
     * @return the GroupName
     */
    public String getGroupName()
    {
        return groupName;
    }

    /**
     * @param groupName the GroupName to set
     */
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    @Override
    public String toString()
    {
        return String.format(" %-10d%-5s \n", groupId,groupName);
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
}

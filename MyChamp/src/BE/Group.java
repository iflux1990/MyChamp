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

    private int groupId;
    private String groupName;

    public Group(int groupId, String groupName)
    {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Group(String groupName)
    {
        this(-1, groupName);

    }

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
     * @param GroupName the GroupName to set
     */
    public void setGroupName(String GroupName)
    {
        this.groupName = GroupName;
    }

    @Override
    public String toString()
    {
        return String.format(" %-30s", groupName);
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }
}

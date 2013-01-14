/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Group;
import DAL.GroupDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Business Layer Logic of the Group table
 * @author Daniel, Marco, Mak & Jonas
 */
public class GroupManager
{

    private GroupDBManager gdb;

    public GroupManager() throws IOException
    {
        gdb = new GroupDBManager();
    }

    public ArrayList<Group> listAllGroups() throws SQLException
    {
        return gdb.listAllGroups();
    }

    public Group getGroupById(int groupId) throws SQLException
    {
        return gdb.getGroupId(groupId);
    }
    
}

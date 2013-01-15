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

    /**
     * Konstruktøren for GroupManager
     * @throws IOException
     */
    public GroupManager() throws IOException
    {
        gdb = new GroupDBManager();
    }

    /**
     * Henter listAllGroups metoden fra DAL laget.
     * @return retunere en liste af grupper
     * @throws SQLException smider SQLExceptions videre.
     */
    public ArrayList<Group> listAllGroups() throws SQLException
    {
        return gdb.listAllGroups();
    }

    /**
     * Henter getGroupById metoden fra DAL laget
     * @param groupId finder den gruppe med et givet groupId.
     * @return Retunere et enkelt objekt med gruppen du søger.
     * @throws SQLException smider SQLException videre.
     */
    public Group getGroupById(int groupId) throws SQLException
    {
        return gdb.getGroupId(groupId);
    }
    
}

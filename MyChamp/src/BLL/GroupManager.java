/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Group;
import DAL.GroupDBManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class GroupManager
{
    private GroupDBManager gdb = null;
    
    public GroupManager() throws IOException
    {
        gdb = new GroupDBManager();
    }
    
    public ArrayList<Group> ListAllGroups() throws SQLException
    {
        return gdb.listAllGroups();
    }
}

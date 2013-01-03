/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Group;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class GroupManager
{
    private GroupDBManager gdb = null;
    
    public GroupManager()
    {
        gdb = new GroupDBManager();
    }
    
    public ArrayList<Group> ListAll()
    {
        return gdb.listAll();
    }
}

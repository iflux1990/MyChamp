/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Group;
import BE.Team;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class GroupDBManager extends ConnectionDBManager
{

    public GroupDBManager() throws IOException
    {
    }

    public ArrayList<Group> listAllGroups() throws  SQLException
            {
        Connection con = dataSource.getConnection();

        String sql = "SELECT * FROM Group";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        ArrayList<Group> group = new ArrayList<>();
        while (rs.next())
        {

            int ID = rs.getInt("ID");
            String GroupName = rs.getString("School");
            String teamcaptain = rs.getString("TeamCaptain");
            String email = rs.getString("Email");
//            int groupid = rs.getInt("GroupID");
//            int points = rs.getInt("Points");


            Group g = new Group(ID, GroupName);
            group.add(g);
        }
        return group;
    }
}

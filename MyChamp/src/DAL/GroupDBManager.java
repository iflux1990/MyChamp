/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Group;
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
    private Group g;
    
    public GroupDBManager() throws IOException
    {
    }

    public ArrayList<Group> listAllGroups() throws SQLException
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
    
     public Group getGroupId(int groupId) throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            
            String sql = ("SELECT * FROM [Group] WHERE ID Like ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 5);
          


            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                String name = rs.getString("GroupName");
                int Id = rs.getInt("ID");

                Group g = new Group(Id, name);
                return g;
            }
            return null;
        }
    }
     
     public void updateGroup(int groupId) throws SQLException
     {
          {

            String sql = "UPDATE Team SET GroupID = ?";

            Connection con;
            try
            {
                con = dataSource.getConnection();
            }
            catch (SQLServerException ex)
            {
                throw new SQLException("Unable to connect to server.");
            }

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, g.getGroupId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to update Group");
            }
        }
     }
}

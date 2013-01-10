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
 * @author Daniel, Marco, Mak & Jonas
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
            String groupName = rs.getString("School");

            Group g1 = new Group(ID, groupName);
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

                Group g1 = new Group(Id, name);
                return g;
            }
            return null;
        }
    }

    public void updateGroup(int groupId) throws SQLException
    {
        {

            String sql = "UPDATE Team SET GroupID = ? WHERE ";

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

    public void assign(Team t, int g) throws SQLException
    {
        String sql = "UPDATE Team SET School = ?, TeamCaptain = ?, Email = ?, GroupId = ? WHERE Id = ?";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
        ps.setInt(4, g);
        ps.setInt(5, t.getTeamId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to insert Team into group");
        }
    }
}

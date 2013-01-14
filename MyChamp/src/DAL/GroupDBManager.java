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

    /**
     * Henter alle grupper fra databasen
     *
     * @return retunere et ArrayList grupper
     * @throws SQLException smider SQLExceptions videre.
     */
    public ArrayList<Group> listAllGroups() throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = "SELECT * FROM [Group]";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();


        ArrayList<Group> Group = new ArrayList<>();
        while (rs.next())
        {

            int ID = rs.getInt("ID");
            String groupName = rs.getString("GroupName");

            Group g1 = new Group(ID, groupName);
            Group.add(g1);
        }
        return Group;
    }

    /**
     * Henter en gruppe fra databasen med et givet Id
     *
     * @param groupId Gruppe Id
     * @return
     * @throws SQLException smider SQLExceptions videre
     */
    public Group getGroupId(int groupId) throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql = ("SELECT * FROM [Group] WHERE ID Like ?");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, groupId);

        ResultSet rs = ps.executeQuery();

        if (rs.next())
        {
            String name = rs.getString("GroupName");
            int Id = rs.getInt("ID");

            Group g1 = new Group(Id, name);
            return g1;
        }
        return null;
    }

    /**
     * opdatere databasen af teams med et givet groupId 
     * @param t et Team objekt
     * @param groupId
     * @throws SQLException smider SQLExceptions videre.
     */
    public void assign(Team t, int groupId) throws SQLException
    {
        String sql = "UPDATE Team SET School = ?, TeamCaptain = ?, Email = ?, GroupId = ? WHERE Id = ?";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, t.getSchoolName());
        ps.setString(2, t.getCaptain());
        ps.setString(3, t.getTeamEmail());
        ps.setInt(4, groupId);
        ps.setInt(5, t.getTeamId());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to insert Team into group");
        }
    }
}

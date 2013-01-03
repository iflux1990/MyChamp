/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 * Hovedmenuen
 * @author Mak, Jonas, Daniel og Marco
 */
public class MainMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    
    /**
     * Constructor, opretter en hovedmenu med titlen "MyTunes" og 
     * to menupunkter administration og control
     */
    public MainMenu()
    {
        super("MyTunes", "Song Administration", "Playlist Administration",
                "Control");
                EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                goToSongMenu();
                break;
            case 2:
                goToPlaylistMenu();
                break;
            case 3:
                goToControlMenu();
                break;
        }
    }

    private void goToSongMenu()
    {
        new SubAdminSong().run();
        clear();
    }
    
    private void goToPlaylistMenu()
    {
        new SubPlaylistMenu().run();
        clear();
    }

    private void goToControlMenu()
    {
        new SubMenuCon().run();
        clear();
    }

}

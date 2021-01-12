package Game;

public class PlayerList{
    private final Player[] Playerlist;
    String[] stringNames;

    public PlayerList(int number, String[] names) {
        stringNames = new String[names.length];
        Playerlist = new Player[number];
        for (int i = 0;i < number;i++)
            Playerlist[i]= new Player(names[i], Player.defaultCash()); //might have solve it, the number of players where set to be the cashamount for the last CDIO
    }

    public Player[] getPlayers() {
        return Playerlist;
    }

    public Player getplayer(int index){
        return Playerlist[index];
    }

    private void test(){

    }
}

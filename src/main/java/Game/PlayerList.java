package Game;

public class PlayerList{
    private final Player[] Playerlist;
    String[] stringNames;

    public PlayerList(int number, String[] names) {
        stringNames = new String[names.length];
        Playerlist = new Player[number];
        for (int i = 0;i < number;i++)
            Playerlist[i]= new Player(names[i], number);
    }

    public Player[] getPlayers() {
        return Playerlist;
    }

    public Player getplayer(int index){
        return Playerlist[index];
    }

}

package Game;

public class PlayerList{
    private Player[] playerList;

    public PlayerList(int number, String[] names) {
        playerList = new Player[number];
        for (int i = 0;i < number;i++)
            playerList[i]= new Player(names[i]);
    }

    public void removePlayer(Player player) {
        Player[] temp = new Player[playerList.length-1];

        int i = 0;
        for (Player p : playerList) {
            if (p != player){
                temp[i++] = p;
            }
        }
        playerList = temp;
    }


    public Player[] getPlayers() {
        return playerList;
    }

    public Player getPlayer(int index){
        return playerList[index];
    }

}

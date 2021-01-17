package Game;

public class Player {

    private static int defaultCash = 30000;
    String name;
    int cash;
    int getOutOfJailFreeCards = 0;
    boolean passedGoThisTurn = false;
    int playerPosition = 0;
    boolean isJailed = false;
    int houses;
    int hotel;
    int jailTurns = 0;


    public Player(String name){
        this.cash = defaultCash; //This is the cash that a player is starting with when a new one is made
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCash() {
        return cash;
    }

    public static int defaultCash(){return defaultCash = 30000;}

    public void addCash(int cash) { this.cash = this.cash + cash; }

    public void addPassStartBonus(int cash) {
        this.cash = this.cash + cash;
        this.passedGoThisTurn = false;
    }

    public int getGetOutOfJailFreeCards() {
        return getOutOfJailFreeCards;
    }

    public void setGetOutOfJailFreeCards(int getOutOfJailFreeCards) {
        this.getOutOfJailFreeCards = getOutOfJailFreeCards;
    }

    public boolean getPassedGoThisTurn() {
        return passedGoThisTurn;
    }

    public void resetHasPassedGo() {
        passedGoThisTurn = false;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int position) {
        if (position < 0) {
            playerPosition = 0;
        } else if (position > 39) {
            playerPosition = 0;
        }
        else
            playerPosition = position;
    }

    public void movePlayer(int amount, int numFields){
        int prevPosition = playerPosition;
        playerPosition = ((playerPosition + amount) % numFields);
        if (prevPosition >= playerPosition) {
            passedGoThisTurn = true;
        }
        if (playerPosition < 0) {
            playerPosition = numFields + playerPosition;
        }
    }

    public boolean isJailed() {
        return isJailed;
    }

    public void setJailed(boolean jailed) {
        isJailed = jailed;
        jailTurns = 0;
    }

    public int getJailTurns() {
        return jailTurns;
    }

    public void setJailTurns(int jailTurns) {
        this.jailTurns = jailTurns;
    }

    public int getHouses() {
        return houses;
    }

    public int getHotel() {
        return hotel;
    }
}


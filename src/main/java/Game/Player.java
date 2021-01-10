package Game;

public class Player {
    String name;
    int cash;
    int getOutOfJailFreeCards = 0;
    boolean passedGoThisTurn = false;
    int playerPosition = 0;
    boolean isBankrupt;
    boolean isJailed = false;
    int Houses;
    int Hotel;

    public Player(String name, int number){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void addCash(int cash) { this.cash = this.cash + cash; }

    public int getGetOutOfJailFreeCards() {
        return getOutOfJailFreeCards;
    }

    public void setGetOutOfJailFreeCards(int getOutOfJailFreeCards) {
        this.getOutOfJailFreeCards = getOutOfJailFreeCards;
    }

    public boolean isPassedGoThisTurn() {
        return passedGoThisTurn;
    }

    public void setPassedGoThisTurn(boolean passedGoThisTurn) {
        this.passedGoThisTurn = passedGoThisTurn;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public boolean isJailed() {
        return isJailed;
    }

    public void setJailed(boolean jailed) {
        isJailed = jailed;
    }

    public int getHouses() {
        return Houses;
    }

    public void setHouses(int houses) {
        Houses = houses;
    }

    public int getHotel() {
        return Hotel;
    }

    public void setHotel(int hotel) {
        Hotel = hotel;
    }
}


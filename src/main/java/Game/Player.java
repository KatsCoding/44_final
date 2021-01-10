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

    public boolean getPassedGoThisTurn() {
        return passedGoThisTurn;
    }

    public void setPassedGoThisTurn(boolean passedGoThisTurn) {
        this.passedGoThisTurn = passedGoThisTurn;
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

    public void movePlayer(int amount){
        int prevPosition = playerPosition;
        playerPosition = ((playerPosition + amount) % 40);
        if (prevPosition >= playerPosition) {
            passedGoThisTurn = true;
        }
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


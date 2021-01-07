package Game;

public class Player {
    String name;
    String Color;
    int cash;
    int getOutOfJailFreeCards = 0;
    boolean passedGoThisTurn = false;
    int playerPosition = 0;
    boolean isBankrupt;
    boolean isJailed = false;

    public Player(String name, String color) {
        this.name = name;
        Color = color;
        this.cash = 30000;
        this.getOutOfJailFreeCards=0;
        this.passedGoThisTurn=false;
        this.playerPosition = 0;
        this.isBankrupt = false;
        this.isJailed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

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
}


package Game;

public class Player {

    private static int defaultCash = 30000;
    String name;
    int cash;
    int getOutOfJailFreeCards = 0;
    boolean passedGoThisTurn = false;
    int playerPosition = 0;
    boolean isBankrupt;
    boolean isJailed = false;
    int Houses;
    int Hotel;
    private boolean hasRolled = false;

    public Player(String name){
        this.cash = defaultCash; //This is the cash that a player is starting with when a new one is made
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

    public static int defaultCash(){return defaultCash = 30000;}

    public void setCash(int cash) {
        this.cash = cash;
    }

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

    public void setPassedGoThisTurn(boolean passedGoThisTurn) {
        this.passedGoThisTurn = passedGoThisTurn;
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

    public void movePlayer(int amount){
        int prevPosition = playerPosition;
        playerPosition = ((playerPosition + amount) % 40);
        if(playerPosition == 2) {setPlayerPosition(3);}
        if(playerPosition == 4) {setPlayerPosition(5);}
        if(playerPosition == 7) {setPlayerPosition(8);}
        if(playerPosition == 17) {setPlayerPosition(18);}
        if(playerPosition == 22) {setPlayerPosition(23);}
        if(playerPosition == 33) {setPlayerPosition(34);}
        if(playerPosition == 36) {setPlayerPosition(37);}
        if(playerPosition == 38) {setPlayerPosition(39);}
        if (prevPosition >= playerPosition) {
            passedGoThisTurn = true;
        }
    }

    public void movePlayer(int amount, int numFields){
        int prevPosition = playerPosition;
        playerPosition = ((playerPosition + amount) % numFields);
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


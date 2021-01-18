package Field;

import Game.Player;

public class ExtraOrdinaryTax extends Fields{

        String propertyName;
        public ExtraOrdinaryTax (String name){
            propertyName = name; }

        @Override
        public Player getOwner() {
            return null;
        }

        @Override
        public void setOwner(Player owner) { }

        @Override
        public boolean getOwned() {
            return false;
        }

        @Override
        public void setOwned(boolean b) {
        }

        @Override
        public int getStreetPrice() {
            return 0;
        }

        @Override
        public int getPrice() {
            return 0;
        }

        @Override
        public char getType() {
            return 0;
        }

        @Override
        public int getCurrentRent() {
            return 0;
        }

        @Override
        public void setRentPriceMultiplier(int b) {

        }

        @Override
        public String getPropertyName() {
            return propertyName;
        }

        @Override
        public String getDisplayPrice() {
            return null;
        }

        @Override
        public int getHouses() {
            return 0;
        }

        @Override
        public int getHousePrice() {
            return 0;
        }

        @Override
        public boolean useMortgage() {
            return false;
        }

        @Override
        public int getMortgage() {
            return 0;
        }

    }

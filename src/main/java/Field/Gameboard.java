package Field;

import Game.Player;

public class Gameboard {
    private Fields[] boardArray = new Fields[40];

    public Gameboard() {
        boardArray[0] = new FieldBlank("Start");
        boardArray[1] = new FieldStreet("Rødovrevej", "1200", 'a', false, 1200, new int[]{50, 250, 750, 2250, 4000, 6000}, 1000, null , 2);
        boardArray[2] = new FieldChanceCard("Prøv lykken");
        boardArray[3] = new FieldStreet("Hvidovrevej", "1200", 'a', false, 1200, new int[]{50, 250, 750, 2250, 4000, 6000}, 1000, null , 2);
        boardArray[4] = new FieldBlank("Indkomstskat");
        boardArray[5] = new FieldShips("Helsingør-Helsingborg","4000", 4000,false,null,'i');
        boardArray[6] = new FieldStreet("Roskildevej", "2000", 'b', false, 2000, new int[]{100, 600, 1800, 5400, 8000, 11000}, 1000, null , 3);
        boardArray[7] = new FieldChanceCard("Prøv lykken");
        boardArray[8] = new FieldStreet("Valby Langgade", "2000", 'b', false, 2000, new int[]{100, 600, 1800, 5400, 8000, 11000}, 1000, null , 3);
        boardArray[9] = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null , 3);
        boardArray[10] = new FieldBlank("Fængsel");
        boardArray[11] = new FieldStreet("Frederiksberg Allé", "2800", 'c', false, 2800, new int[]{200, 1000, 3000, 9000, 12500, 15000}, 2000, null , 3);
        boardArray[12] = new FieldBrewery("Tuborg", 3000, false,null,'j');
        boardArray[13] = new FieldStreet("Bülowsvej", "2800", 'c', false, 2800, new int[]{200, 1000, 3000, 9000, 12500, 15000}, 2000, null , 3);
        boardArray[14] = new FieldStreet("Gl. Kongevej", "3200", 'c', false, 3200, new int[]{250, 1250, 3750, 10000, 14000, 18000}, 2000, null , 3);
        boardArray[15] = new FieldShips("Mols-Linien", "4000",4000,false,null,'i');
        boardArray[16] = new FieldStreet("Bernstorffsvej", "3600", 'd', false, 3600, new int[]{300, 1400, 4000, 11000, 15000, 19000}, 2000, null , 3);
        boardArray[17] = new FieldChanceCard("Prøv lykken");;
        boardArray[18] = new FieldStreet("Hellerupvej", "3600", 'd', false, 3600, new int[]{300, 1400, 4000, 11000, 15000, 19000}, 2000, null , 3);
        boardArray[19] = new FieldStreet("Strandvejen", "4000", 'd', false, 3600, new int[]{350, 1600, 4400, 12000, 16000, 20000}, 2000, null , 3);
        boardArray[20] = new FieldBlank("Parkering");
        boardArray[21] = new FieldStreet("Trianglen", "4400", 'e', false, 4400, new int[]{350, 1800, 5000, 14000, 17500, 21000}, 3000, null , 3);
        boardArray[22] = new FieldChanceCard("Prøv lykken");;
        boardArray[23] = new FieldStreet("Østerbrogade", "4400", 'e', false, 4400, new int[]{350, 1800, 5000, 14000, 17500, 21000}, 3000, null , 3);
        boardArray[24] = new FieldStreet("Grønningen", "4800", 'e', false, 4800, new int[]{400, 2000, 6000, 15000, 18500, 22000}, 3000, null , 3);
        boardArray[25] = new FieldShips("Gedser-Rostock","4000", 4000,false,null,'i');
        boardArray[26] = new FieldStreet("Bredgade", "5200", 'f', false, 5200, new int[]{450, 2200, 6600, 16000, 19500, 23000}, 3000, null , 3);
        boardArray[27] = new FieldStreet("Kgs. Nytorv", "5200", 'f', false, 5200, new int[]{450, 2200, 6600, 16000, 19500, 23000}, 3000, null , 3);
        boardArray[28] = new FieldBrewery("Carlsberg", 3000, false,null,'j');
        boardArray[29] = new FieldStreet("Østergade", "5600", 'f', false, 5600, new int[]{500, 2400, 7200, 17000, 20500, 24000}, 3000, null , 3);
        boardArray[30] = new FieldJail("Ryk i fængsel");
        boardArray[31] = new FieldStreet("Amagertorv", "6000", 'g', false, 6800, new int[]{550, 2600, 7800, 18000, 22000, 25000}, 4000, null , 3);
        boardArray[32] = new FieldStreet("Vimmelskaftet", "6000", 'g', false, 6000,new int[]{550, 2600, 7800, 18000, 22000, 25000},4000, null , 3);
        boardArray[33] = new FieldChanceCard("Prøv lykken");;
        boardArray[34] = new FieldStreet("Nygade", "6400", 'g', false, 6400, new int[]{600, 3000, 9000, 20000, 24000, 28000}, 4000, null , 3);
        boardArray[35] = new FieldShips("Rødby-Puttgarden", "4000",4000,false,null,'i');
        boardArray[36] = new FieldChanceCard("Prøv lykken");;
        boardArray[37] = new FieldStreet("Frederiksberg", "7000", 'h', false, 7000, new int[]{700, 3500, 10000, 22000, 26000, 30000}, 4000, null , 2);
        boardArray[38] = new FieldBlank("Statsskat");
        boardArray[39] = new FieldStreet("Rådhuspladsen", "8000", 'h', false, 8000, new int[]{1000, 40000, 12000, 28000, 34000, 40000}, 4000 , null,2);

    }

    public Fields[] getArray() {
        return boardArray;
    }


    //tæller hvor mange færger man owner
    public int ShipOwnerCounter(Player player) {
        int counter = 0;
        for (int i = 0; i < boardArray.length; i++) {
            if (i == 5 || i == 15 || i == 25 || i == 35) {
                if (player == ((FieldShips) boardArray[i]).getOwner()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    //tæller hvor mange Bryggerier man ejere
    public int breweryOwnerCounter(Player player) {
        int counter = 0;
        for (int i = 0; i < boardArray.length; i++) {
            if (i == 12 || i == 28) {
                if (player == ((FieldBrewery) boardArray[i]).getOwner()) {
                    counter++;

                }
            }
        }
        return counter;
    }
}

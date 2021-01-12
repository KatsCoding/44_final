package GUI;
import Field.Gameboard;
import gui_fields.*;


import java.awt.*;

public class GUI_game {
    private int house;
    private boolean hotel;
    static GUI_Field[] gui_fields = new GUI_Field[40];
    GUI_Street street = new GUI_Street();

    public static  GUI_Field[] makeGUIFields(){//make GUI board with the data from Gameboard class
        Gameboard gameboard = new Gameboard();

        gui_fields[0] = new GUI_Start(gameboard.getArray()[0].getPropertyName(), "" ,"Hver gang du passere START modtag kr. 4000" ,new Color(255, 31 , 31) , Color.WHITE);
        gui_fields[1] = new GUI_Street(gameboard.getArray()[1].getPropertyName(), gameboard.getArray()[1].getDisplayPrice(), "", gameboard.getArray()[1].getDisplayPrice(), new Color(44,14, 235), Color.WHITE);
        gui_fields[2] = new GUI_Chance( "?","Prøv lykken" ,"" , Color.BLACK, Color.WHITE );
        gui_fields[3] = new GUI_Street(gameboard.getArray()[3].getPropertyName(),gameboard.getArray()[3].getDisplayPrice() ,"" , gameboard.getArray()[3].getDisplayPrice(), new Color(44,14, 235), Color.WHITE);
        gui_fields[4] = new GUI_Tax("Betal-\n"+"indkomstskat:\n"+"10% eller\n"+"4000 kr."," " ,"" , Color.WHITE,  Color.BLACK);
        gui_fields[5] = new GUI_Shipping("default",gameboard.getArray()[5].getPropertyName() ,gameboard.getArray()[5].getDisplayPrice(), "", "" , new Color(44,14, 235), Color.WHITE);
        gui_fields[6] = new GUI_Street(gameboard.getArray()[6].getPropertyName(),gameboard.getArray()[6].getDisplayPrice() ,"" , gameboard.getArray()[6].getDisplayPrice(), new Color(238, 45, 18), Color.WHITE);
        gui_fields[7] = new GUI_Chance( "?","Prøv lykken" ,"" ,Color.BLACK ,Color.GREEN );
        gui_fields[8] = new GUI_Street(gameboard.getArray()[8].getPropertyName(), gameboard.getArray()[8].getDisplayPrice(),"" ,gameboard.getArray()[8].getDisplayPrice(), new Color(238, 45, 18), Color.WHITE);
        gui_fields[9] = new GUI_Street(gameboard.getArray()[9].getPropertyName(), gameboard.getArray()[9].getDisplayPrice() ,"" ,gameboard.getArray()[9].getDisplayPrice(),  new Color(238, 45, 18), Color.WHITE);
        gui_fields[10] = new GUI_Jail("default","" ,"" , "",Color.WHITE  ,Color.WHITE);
        gui_fields[11] = new GUI_Street(gameboard.getArray()[11].getPropertyName(),gameboard.getArray()[11].getDisplayPrice() ,"" ,gameboard.getArray()[11].getDisplayPrice(), new Color(168, 114, 8), Color.WHITE);
        gui_fields[12] = new GUI_Brewery("default","" ,"3000 kr." , "", "" ,new Color(23, 255, 0)  ,Color.BLACK);
        gui_fields[13] = new GUI_Street(gameboard.getArray()[13].getPropertyName(),gameboard.getArray()[13].getDisplayPrice() ,"" ,gameboard.getArray()[13].getDisplayPrice(),  new Color(168, 114, 8), Color.WHITE);
        gui_fields[14] = new GUI_Street(gameboard.getArray()[14].getPropertyName(),gameboard.getArray()[14].getDisplayPrice() ,"" ,gameboard.getArray()[14].getDisplayPrice(),  new Color(168, 114, 8), Color.WHITE);
        gui_fields[15] = new GUI_Shipping("default",gameboard.getArray()[15].getPropertyName() ,gameboard.getArray()[15].getDisplayPrice() , "", "" , new Color(255, 31 , 31),Color.WHITE);
        gui_fields[16] = new GUI_Street(gameboard.getArray()[16].getPropertyName(),gameboard.getArray()[16].getDisplayPrice() ,"" ,gameboard.getArray()[16].getDisplayPrice(),  new Color(115, 113, 120), Color.WHITE);
        gui_fields[17] = new GUI_Chance( "?","Prøv lykken" ,"" , Color.BLACK, Color.GREEN);
        gui_fields[18] = new GUI_Street(gameboard.getArray()[18].getPropertyName(),gameboard.getArray()[18].getDisplayPrice() ,"" , gameboard.getArray()[18].getDisplayPrice(), new Color(115, 113, 120), Color.WHITE);
        gui_fields[19] = new GUI_Street(gameboard.getArray()[19].getPropertyName(),gameboard.getArray()[19].getDisplayPrice() ,"" , gameboard.getArray()[19].getDisplayPrice(),  new Color(115, 113, 120), Color.WHITE);
        gui_fields[20] = new GUI_Refuge("default","" ,"" ,"" ,Color.WHITE  , Color.WHITE);
        gui_fields[21] = new GUI_Street(gameboard.getArray()[21].getPropertyName(),gameboard.getArray()[21].getDisplayPrice() ,"" , gameboard.getArray()[21].getDisplayPrice(),  new Color(246, 3, 3), Color.WHITE);
        gui_fields[22] = new GUI_Chance( "?","Prøv lykken" ,"" , Color.BLACK, Color.GREEN );
        gui_fields[23] = new GUI_Street(gameboard.getArray()[23].getPropertyName(),gameboard.getArray()[23].getDisplayPrice() ,"" , gameboard.getArray()[23].getDisplayPrice(), new Color(246, 3, 3), Color.WHITE);
        gui_fields[24] = new GUI_Street(gameboard.getArray()[24].getPropertyName(),gameboard.getArray()[24].getDisplayPrice() ,"" , gameboard.getArray()[24].getDisplayPrice(),  new Color(246, 3, 3), Color.WHITE);
        gui_fields[25] = new GUI_Shipping("default",gameboard.getArray()[25].getPropertyName() ,gameboard.getArray()[25].getDisplayPrice() , "", "" , new Color(44,14, 235), Color.WHITE);
        gui_fields[26] = new GUI_Street(gameboard.getArray()[26].getPropertyName(),gameboard.getArray()[26].getDisplayPrice() ,"" , gameboard.getArray()[26].getDisplayPrice(),  new Color(255, 255, 255), Color.BLACK);
        gui_fields[27] = new GUI_Street(gameboard.getArray()[27].getPropertyName(),gameboard.getArray()[27].getDisplayPrice() ,"" , gameboard.getArray()[27].getDisplayPrice(),  new Color(255, 255, 255), Color.BLACK);
        gui_fields[28] = new GUI_Brewery("default","" ,"3000 kr." , "", "" , new Color(23, 255, 0),Color.BLACK);
        gui_fields[29] = new GUI_Street(gameboard.getArray()[29].getPropertyName(),gameboard.getArray()[29].getDisplayPrice() ,"" , gameboard.getArray()[29].getDisplayPrice(),  new Color(255, 255, 255), Color.BLACK);
        gui_fields[30] = new GUI_Jail("default","" ,"" ,"" ,Color.WHITE  , Color.WHITE);
        gui_fields[31] = new GUI_Street(gameboard.getArray()[31].getPropertyName(),gameboard.getArray()[31].getDisplayPrice() ,"" , gameboard.getArray()[31].getDisplayPrice(),  new Color(255, 193, 0), Color.WHITE);
        gui_fields[32] = new GUI_Street(gameboard.getArray()[32].getPropertyName(),gameboard.getArray()[32].getDisplayPrice() ,"" ,gameboard.getArray()[32].getDisplayPrice(), new Color(255, 193, 0), Color.WHITE);
        gui_fields[33] = new GUI_Chance( "?","Prøv lykken" ,"" , Color.BLACK, Color.GREEN );
        gui_fields[34] = new GUI_Street(gameboard.getArray()[34].getPropertyName(),gameboard.getArray()[34].getDisplayPrice() ,"" , gameboard.getArray()[34].getDisplayPrice(), new Color(255, 193, 0), Color.WHITE);
        gui_fields[35] = new GUI_Shipping("default",gameboard.getArray()[35].getPropertyName() ,gameboard.getArray()[35].getDisplayPrice() , "", "" ,new Color(44,14, 235) ,Color.WHITE);
        gui_fields[36] = new GUI_Chance( "?","Prøv lykken" ,"" , Color.BLACK, Color.WHITE);
        gui_fields[37] = new GUI_Street(gameboard.getArray()[37].getPropertyName(),gameboard.getArray()[37].getDisplayPrice() ,"" , gameboard.getArray()[37].getDisplayPrice(), new Color(104, 3, 87), Color.WHITE);
        gui_fields[38] = new GUI_Tax("Ekstraordinær-\n"+"statsskat: \n"+"betal 2000 kr.","" ,"" , Color.WHITE, Color.BLACK );
        gui_fields[39] = new GUI_Street(gameboard.getArray()[39].getPropertyName(),gameboard.getArray()[39].getDisplayPrice() ,"" , gameboard.getArray()[39].getDisplayPrice(), new Color(104, 3, 87), Color.WHITE);

        return gui_fields;
    }

    public int getGui_house(int i){//method for GUI house

        street.setHouses(i);
        return house;
    }

    public boolean setHotel(){//method for GUI hotel

        street.setHotel(false);
        return hotel;
    }
}

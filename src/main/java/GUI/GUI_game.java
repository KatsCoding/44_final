package GUI;
import Field.Gameboard;
import gui_fields.*;


import java.awt.*;

public class GUI_game {
    private int house;
    static GUI_Field[] gui_fields = new GUI_Field[40];
    GUI_Street street = new GUI_Street();

    public static  GUI_Field[] makeGUIFields(){//Laver GUI boardet ud fra data'en i 'Gameboard
        Gameboard gameboard = null;
        int i = 0;
        gui_fields[0] = new GUI_Start(gameboard.getArray()[0].FieldStart(), "Hver gang du passere START modtag kr. 4000" ,"" ,new Color(255, 31 , 31) , Color.WHITE);
        gui_fields[1] = new GUI_Street(gameboard.getArray()[1].getPropertyName(), "SUBTEXT", "DESCRIPTION", gameboard.getArray()[1].getStreetPrice(), Color.BLACK, Color.blue);
        gui_fields[2] = new GUI_Chance();
        gui_fields[3] = new GUI_Street(gameboard.getArray()[3].getPropertyName(),"d" ,"d" , gameboard.getArray()[3].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[4] = new GUI_Tax();
        gui_fields[5] = new GUI_Shipping();
        gui_fields[6] = new GUI_Street(gameboard.getArray()[6].getPropertyName(),"d" ,"d" , gameboard.getArray()[6].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[7] = new GUI_Chance();
        gui_fields[8] = new GUI_Street(gameboard.getArray()[8].getPropertyName(), "d" ,"d" ,gameboard.getArray()[8].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[9] = new GUI_Street(gameboard.getArray()[9].getPropertyName(), "d" ,"d" ,gameboard.getArray()[9].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[10] = new GUI_Jail();
        gui_fields[11] = new GUI_Street(gameboard.getArray()[11].getPropertyName(),"d" ,"d" ,gameboard.getArray()[11].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[12] = new GUI_Brewery();
        gui_fields[13] = new GUI_Street(gameboard.getArray()[13].getPropertyName(),"d" ,"d" ,gameboard.getArray()[13].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[14] = new GUI_Street(gameboard.getArray()[14].getPropertyName(),"d" ,"d" ,gameboard.getArray()[14].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[15] = new GUI_Shipping();
        gui_fields[16] = new GUI_Street(gameboard.getArray()[16].getPropertyName(),"d" ,"d" ,gameboard.getArray()[16].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[17] = new GUI_Chance();
        gui_fields[18] = new GUI_Street(gameboard.getArray()[18].getPropertyName(),"d" ,"d" , gameboard.getArray()[18].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[19] = new GUI_Street(gameboard.getArray()[19].getPropertyName(),"d" ,"d" , gameboard.getArray()[19].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[20] = new GUI_Empty();
        gui_fields[21] = new GUI_Street(gameboard.getArray()[21].getPropertyName(),"d" ,"d" , gameboard.getArray()[21].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[22] = new GUI_Chance();
        gui_fields[23] = new GUI_Street(gameboard.getArray()[23].getPropertyName(),"d" ,"d" , gameboard.getArray()[23].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[24] = new GUI_Street(gameboard.getArray()[24].getPropertyName(),"d" ,"d" , gameboard.getArray()[24].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[25] = new GUI_Shipping();
        gui_fields[26] = new GUI_Street(gameboard.getArray()[26].getPropertyName(),"d" ,"d" , gameboard.getArray()[26].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[27] = new GUI_Street(gameboard.getArray()[27].getPropertyName(),"d" ,"d" , gameboard.getArray()[27].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[28] = new GUI_Brewery();
        gui_fields[29] = new GUI_Street(gameboard.getArray()[29].getPropertyName(),"d" ,"d" , gameboard.getArray()[29].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[30] = new GUI_Refuge();
        gui_fields[31] = new GUI_Street(gameboard.getArray()[31].getPropertyName(),"d" ,"d" , gameboard.getArray()[31].getStreetPrice(),  new Color(), Color.WHITE);
        gui_fields[32] = new GUI_Street(gameboard.getArray()[32].getPropertyName(),"d" ,"d" ,gameboard.getArray()[32].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[33] = new GUI_Chance();
        gui_fields[34] = new GUI_Street(gameboard.getArray()[34].getPropertyName(),"d" ,"d" , gameboard.getArray()[34].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[35] = new GUI_Shipping();
        gui_fields[36] = new GUI_Chance();
        gui_fields[37] = new GUI_Street(gameboard.getArray()[37].getPropertyName(),"d" ,"d" , gameboard.getArray()[37].getStreetPrice(), new Color(), Color.WHITE);
        gui_fields[38] = new GUI_Tax();
        gui_fields[39] = new GUI_Street(gameboard.getArray()[39].getPropertyName(),"d" ,"d" , gameboard.getArray()[39].getStreetPrice(), new Color(), Color.WHITE);

        return gui_fields;
    }

    public int getGui_house(){

        street.setHouses(2);
        return house;
    }
}

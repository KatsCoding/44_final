package GUI;
import Field.Gameboard;
import gui_fields.GUI_Ownable;
import gui_main.GUI;

import gui_fields.GUI_Field;

import java.awt.*;

public class GUI_Controller {


    public static void main(String[] args){

        GUI_Field[] fields = GUI_game.makeGUIFields();
        ((GUI_Ownable)fields[0]).setBorder(Color.BLACK, Color.BLACK);
        GUI gui = new GUI(fields, Color.WHITE);


    }
}

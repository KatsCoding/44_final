package GUI;
import Field.Gameboard;
import gui_main.GUI;

import gui_fields.GUI_Field;

import java.awt.*;

public class GUI_Controller {


    public static void main(String[] args){

        GUI_Field[] fields = GUI_game.makeGUIFields();

        GUI gui = new GUI(fields, Color.WHITE);
    }
}

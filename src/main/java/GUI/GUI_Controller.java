package GUI;
import Game.Gameboard;
import gui_main.GUI;

import gui_fields.GUI_Field;

import java.awt.*;

public class GUI_Controller {


    public static void main(String[] args){

        GUI_Field[] fields = GUI.makeGUIFields();

        GUI gui = new GUI(fields, Color.WHITE);
    }
}

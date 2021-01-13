package Game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Field.*;
import GUI.*;
/*
public class TurnController {
    
    private boolean TurnController( Player player ) {
        int choise = Integer.parseInt(gui.getUserSelection( player, 1, 8 ));

        boolean endTurn = false;

        switch( choise ){

            case 0: // Slaa med Terninger
                if ( !player.erIFaengsel() ) {
                    rykSpiller.kastTerninger(spil, spil.getSpillerMedTur(), ui, this);

                } else{
                    ui.kanIkkeSlaaFaengsel();

                }
                break;

            case 1: // Slutter turen
                endTurn = true;
                break;

            case 2: // Viser chancekort paa handen
                handlinger.chanceKortMuligheder( spiller, this, ui);
                break;

            case 3: // Giver op
                if( handlinger.givOp( ui ) ){
                    endTurn = true;
                    spillerUdgaar( spiller );
                    ui.harGivetOp( spiller );
                }
                break;

            case 4: // Koeber hus
                handelHus.koebHus( spiller, ui );
                break;

            case 5: // Koeb Hotel
                handelHotel.koebHotelForloeb( spiller, ui );
                break;

            case 6: // Saelg hus
                handelHus.saelgHus( spiller, ui );
                break;

            case 7: // Saelg hotel
                handelHotel.saelgHotelForloeb( spiller, ui );
                break;
        }

        return endTurn;
    }
}
*/
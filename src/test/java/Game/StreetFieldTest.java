package Game;

import Field.FieldBrewery;
import Field.FieldShips;
import Field.FieldStreet;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StreetFieldTest {
    @Test
    void testStreetCreation() {
        FieldStreet tester = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);

        assertEquals("Allégade", tester.getPropertyName());
        assertEquals("2400",tester.getDisplayPrice());
        assertEquals('b', tester.getType());
        assertEquals(false, tester.getOwned());
        assertEquals(2400,tester.getStreetPrice());
        assertEquals(150, tester.getCurrentRent());
    }
    @Test
    void testBuildMaxFourHouses() {
        Player player = new Player("Simon");
        FieldStreet tester = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);


        assertEquals(0,tester.getHouses());
        tester.setOwner(player);
        tester.setCanBuild(true);
        assertEquals(true, tester.canBuildHouse());

        assertEquals(true,tester.buildHouse());
        assertEquals(1,tester.getHouses());
        assertEquals(800,tester.getCurrentRent());

        assertEquals(true,tester.buildHouse());
        assertEquals(2,tester.getHouses());

        assertEquals(true,tester.buildHouse());
        assertEquals(3,tester.getHouses());

        assertEquals(true,tester.canBuildHouse());
        assertEquals(true,tester.buildHouse());
        assertEquals(4,tester.getHouses());
        assertEquals(tester.getCurrentRent(),9000);

        assertEquals(false,tester.canBuildHouse());
        assertEquals(false,tester.buildHouse());
        assertEquals(4,tester.getHouses());
    }

    @Test
    void testCannotBuildWithoutOwner() {
        FieldStreet tester = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        assertEquals(false, tester.canBuildHouse());
    }

    @Test
    void testCanLinkFields(){
        FieldStreet testStreetBlue1 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue2 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue3 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetGreen = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet.linkFields(new FieldStreet[]{testStreetBlue1, testStreetBlue2, testStreetBlue3});

        assertSame(testStreetBlue2,testStreetBlue1.getRelatedFields().get(0));
        assertSame(testStreetBlue3,testStreetBlue1.getRelatedFields().get(1));

        assertSame(testStreetBlue1,testStreetBlue2.getRelatedFields().get(0));
        assertSame(testStreetBlue3,testStreetBlue2.getRelatedFields().get(1));

        assertSame(testStreetBlue1,testStreetBlue3.getRelatedFields().get(0));
        assertSame(testStreetBlue2,testStreetBlue3.getRelatedFields().get(1));

        assertEquals(true,testStreetGreen.getRelatedFields().isEmpty());
    }

    @Test
    void testCanPlayerBuyHouseWithoutOwningAllRelatedFields(){
        Player player1 = new Player("Simon");
        Player player2 = new Player("Nico");
        FieldStreet testStreetBlue1 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue2 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue3 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);

        FieldStreet.linkFields(new FieldStreet[]{testStreetBlue1, testStreetBlue2, testStreetBlue3});
    }

    @Test
    void testBuyShipAndCola() {
        FieldShips tester = new FieldShips("mols","4000",4000,false,null,'b');
        FieldBrewery tester2 = new FieldBrewery("cola",4000,false,null,'a');

        assertEquals("mols", tester.getPropertyName());
        assertEquals(4000,tester.getPrice());
        assertEquals('b', tester.getType());
        assertEquals(false, tester.getOwned());

        assertEquals("cola",tester2.getPropertyName());

    }


}

package Game;

import Field.FieldStreet;
import org.junit.jupiter.api.Test;

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
        Player player = new Player("Simon",1);
        FieldStreet tester = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        assertEquals(0,tester.getHouses());
        tester.setOwner(player);
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
        Player player = new Player("Simon",1);
        Player player = new Player("Nico",2);
        FieldStreet testStreetBlue1 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue2 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);
        FieldStreet testStreetBlue3 = new FieldStreet("Allégade", "2400", 'b', false, 2400, new int[]{150, 800, 2000, 6000, 9000, 12000}, 1000, null, 3);

        FieldStreet.linkFields(new FieldStreet[]{testStreetBlue1, testStreetBlue2, testStreetBlue3});

    }

}

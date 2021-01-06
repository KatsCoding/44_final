package Game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void roll() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int[] sumOfDiceCount = new int[11];
        int sameEyesOnDice = 0;

        int i = 0;
        do {

            int dice1Roll = dice1.roll();
            int dice2Roll = dice2.roll();

            int sum = dice1Roll + dice2Roll;
            sumOfDiceCount[sum-2] += 1;


            if (dice1Roll == dice2Roll) {
                sameEyesOnDice = sameEyesOnDice + 1;
            }


            i = i + 1;
        } while (i < 1000);


        System.out.println("Number of eyes from 2 to 12 starting lowest to highest:\t\t\t" + Arrays.toString(sumOfDiceCount));
        System.out.println("Number of dice rolls with the same number of eyes on each die:\t" + sameEyesOnDice);

        double[] actualProbabilities = new double[11];
        int j = 0;
        while(j < sumOfDiceCount.length) {
            actualProbabilities[j] = (double) sumOfDiceCount[j]/1000*100;
            j = j + 1;
        }

        System.out.println("\n");
        System.out.println("Expected probabilities for number of eyes:\t[2.78, 5.56, 8.33, 11.11, 13.89, 16.67, 13.89, 11.11, 8.33, 5.56, 2.78]" );
        System.out.println("Actual probabilities for number of eyes:\t" + Arrays.toString(actualProbabilities));

        System.out.println();
        System.out.println("Expected probability for same number of eyes on each die:\t" + 16.667);
        System.out.println("Actual probability for same number of eyes on each die:\t\t" + (double) sameEyesOnDice/1000*100);
    }

    @Test
    void getEyeValue() {
        Dice dice = new Dice();
        var rollValue = dice.roll();

        assertEquals(rollValue, dice.getEyeValue());
        System.out.println("roll value is the same as dice.getEyeValue");
        assertEquals(rollValue, dice.getEyeValue());
        System.out.println("Checking if roll value is the same as a second call to dice.getEyeValue");
        assertEquals(dice.getEyeValue(), dice.getEyeValue());
        System.out.println("Checking that dice.getEyeValue is the same as dice.getEyeValue. It is.");

        System.out.println("Rolling new die");
        int rollValuePT2;
        do {
            rollValuePT2 = dice.roll();
        }
        while (rollValuePT2 == rollValue);
        System.out.println("Old roll value is" + rollValue + ". New roll value is" + rollValuePT2 + ".");

        assertNotEquals(rollValue, dice.getEyeValue());
        System.out.println("Old roll value is not the same as dice.getEyeValue");
        assertEquals(rollValuePT2, dice.getEyeValue());
        System.out.println("roll value is the same as dice.getEyeValue");
        assertEquals(rollValuePT2, dice.getEyeValue());
        System.out.println("Checking if roll value is the same as a second call to dice.getEyeValue");
        assertEquals(dice.getEyeValue(), dice.getEyeValue());
        System.out.println("Checking that dice.getEyeValue is the same as dice.getEyeValue. It is.");
    }
}
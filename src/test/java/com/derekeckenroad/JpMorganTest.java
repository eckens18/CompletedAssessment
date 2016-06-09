package com.derekeckenroad;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JpMorganTest {

    @Test
    public void intFinder(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber = "(302)-678-3302";
        ArrayList<String> actual = jpMorgan.intFinder(phoneNumber);
        assertNotNull(actual);
    }

    @Test
    public void testWithPhoneNumberWithParenthsis(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber = "(302)-678-3302";
        boolean actual = jpMorgan.checkIfPhoneNumber(phoneNumber);
        assertTrue(actual);
    }

    @Test
    public void testWithPhoneNumberWithJustSpaces(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber2 = "901 458 6849";
        boolean actual = jpMorgan.checkIfPhoneNumber(phoneNumber2);
        assertTrue(actual);
    }

    @Test
    public void testIfTimeTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String time = "3:35pm";
        boolean actual = jpMorgan.checkIfTime(time);
        assertTrue(actual);
    }

    @Test
    public void convertPhoneWithParenToWordsTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber = "(302)-678-3302";
        ArrayList<String> array = jpMorgan.intFinder(phoneNumber);
        String actual = jpMorgan.convertPhoneToWords(array);
        String expected = "ThreeZeroTwo SixSevenEight ThreeThreeZeroTwo";
        assertEquals(actual,expected);
    }

    @Test
    public void convertPhoneWithoutParenToWordsTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber = "245-907-2388";
        ArrayList<String> array = jpMorgan.intFinder(phoneNumber);
        String actual = jpMorgan.convertPhoneToWords(array);
        String expected = "TwoFourFive NineZeroSeven TwoThreeEightEight";
        assertEquals(actual,expected);
    }

    @Test
    public void convertPhoneWithoutSpacesToWordsTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String phoneNumber = "1234567890";
        ArrayList<String> array = jpMorgan.intFinder(phoneNumber);
        String actual = jpMorgan.convertPhoneToWords(array);
        String expected = "OneTwoThree FourFiveSix SevenEightNineZero";
        assertEquals(actual,expected);
    }

    @Test
    public void convertTimeToWordsWithPMTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String time = "3:35PM";
        String actual = jpMorgan.convertTimeToWords(time);
        String expected = "Three ThirtyFive Post Meridiem";
        assertEquals(actual,expected);
    }

    @Test
    public void convertTimeToWordsWithoutAMPMTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String time = "03:00";
        String actual = jpMorgan.convertTimeToWords(time);
        String expected = "Three Hundred Hours";
        assertEquals(actual,expected);
    }

    /*@Test
    public void trimLeadingZeroTest(){
        JpMorgan jpMorgan = new JpMorgan();
        assertEquals("3",jpMorgan.trimLeadingZero("03"));
    }*/

    @Ignore
    public void convertToWordsTest(){
        JpMorgan jpMorgan = new JpMorgan();
        String time = "3:35pm";
        String phoneNumber = "(302)-678-3302";
        String actual = jpMorgan.convertToWords();
        String actual2 = jpMorgan.convertToWords();
        String expected = "Three ThirtyFive prime meridian";
        String expected2 = "ThreeOneTwo SixSevenEight ThreeThreeOneTwo";
        assertEquals(actual,expected);
        assertEquals(actual2,expected2);
    }
}

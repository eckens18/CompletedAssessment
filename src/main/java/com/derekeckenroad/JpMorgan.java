package com.derekeckenroad;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.HashMap;

public class JpMorgan {

    Map<String, String> stringNumberConverter = new HashMap<String, String>();

    public JpMorgan(){
        stringNumberConverter.put("0","Zero");
        stringNumberConverter.put("1","One");
        stringNumberConverter.put("2","Two");
        stringNumberConverter.put("3","Three");
        stringNumberConverter.put("4","Four");
        stringNumberConverter.put("5","Five");
        stringNumberConverter.put("6","Six");
        stringNumberConverter.put("7","Seven");
        stringNumberConverter.put("8","Eight");
        stringNumberConverter.put("9","Nine");
        stringNumberConverter.put("10","ten");
        stringNumberConverter.put("11","Eleven");
        stringNumberConverter.put("12","Twelve");
        stringNumberConverter.put("13","Thirteen");
        stringNumberConverter.put("14","Fourteen");
        stringNumberConverter.put("15","Fifteen");
        stringNumberConverter.put("16","Sixteen");
        stringNumberConverter.put("17","Seventeen");
        stringNumberConverter.put("18","Eighteen");
        stringNumberConverter.put("19","Nineteen");
        stringNumberConverter.put("20","Twenty");
        stringNumberConverter.put("21","Twenty");
        stringNumberConverter.put("22","TwentyTwo");
        stringNumberConverter.put("23","TwentyThree");
        stringNumberConverter.put("24","TwentyFour");
        stringNumberConverter.put("25","TwentyFive");
        stringNumberConverter.put("26","TwentySix");
        stringNumberConverter.put("27","TwentySeven");
        stringNumberConverter.put("28","TwentyEight");
        stringNumberConverter.put("29","TwentyNine");
        stringNumberConverter.put("30","Thirty");
        stringNumberConverter.put("31","ThirtyOne");
        stringNumberConverter.put("32","ThirtyTwo");
        stringNumberConverter.put("33","ThirtyThree");
        stringNumberConverter.put("34","ThirtyFour");
        stringNumberConverter.put("35","ThirtyFive");
        stringNumberConverter.put("36","ThirtySix");
        stringNumberConverter.put("37","ThirtySeven");
        stringNumberConverter.put("38","ThirtyEight");
        stringNumberConverter.put("39","ThirtyNine");
        stringNumberConverter.put("40","Forty");
        stringNumberConverter.put("41","FortyOne");
        stringNumberConverter.put("42","FortyTwo");
        stringNumberConverter.put("43","FortyThree");
        stringNumberConverter.put("44","FortyFour");
        stringNumberConverter.put("45","FortyFive");
        stringNumberConverter.put("46","FortySix");
        stringNumberConverter.put("47","FortySeven");
        stringNumberConverter.put("48","FortyEight");
        stringNumberConverter.put("49","FortyNine");
        stringNumberConverter.put("50","Fifty");
        stringNumberConverter.put("51","FiftyOne");
        stringNumberConverter.put("52","FiftyTwo");
        stringNumberConverter.put("53","FiftyThree");
        stringNumberConverter.put("54","FiftyFour");
        stringNumberConverter.put("55","FiftyFive");
        stringNumberConverter.put("56","FiftySix");
        stringNumberConverter.put("57","FiftySeven");
        stringNumberConverter.put("58","FiftyEight");
        stringNumberConverter.put("59","FiftyNine");
        stringNumberConverter.put("pm","Post Meridiem");
        stringNumberConverter.put("am","Ante Meridiem");
        stringNumberConverter.put("00","O'clock");
    }

    public ArrayList<String> intFinder(String phoneNumber) {
        ArrayList<String> numbers = new ArrayList<String>();
        Pattern p = Pattern.compile("([0-9])");
        Matcher m = p.matcher(phoneNumber);
        while (m.find()) {
            numbers.add(m.group(1));
            }
        return numbers;
    }

    public boolean checkIfPhoneNumber(String string){
        Pattern p = Pattern.compile("(\\(?\\d{3}\\)?[-\\s]\\d{3}[-\\s]\\d{4}|\\d{10})");
        Matcher m = p.matcher(string);
        if(m.find()){
            return true;
        }
        return false;
    }

    public boolean checkIfTime(String string){
        Pattern p = Pattern.compile("(\\d{1,2}\\:\\d{2}(\\D{2})?)");
        Matcher m = p.matcher(string);
        if(m.find()){
            return true;
        }
        return false;
    }

    public String convertPhoneToWords(ArrayList<String> array){
        String convertedPhoneNumber = "";
        int count=0;
        for(String num : array) {
            count++;
            convertedPhoneNumber += stringNumberConverter.get(num);
            if(count==3|count==6){convertedPhoneNumber += " ";}
        }
        return convertedPhoneNumber;
    }

    public String convertTimeToWords(String string){
        String convertedTime = "";
        String [] timeSplit = string.split("(:)|(?=\\D{2})");
        for(int i = 0; i<timeSplit.length;i++) {
            if(isMilitary(string) && timeSplit[i].equals("00") && i==1){
                convertedTime += "Hundred" + " ";
            } else {
                convertedTime += stringNumberConverter.get(trimLeadingZero(timeSplit[i]).toLowerCase()) + " ";
            }
        }
        if(isMilitary(string)){
            convertedTime += "Hours";
        }
        return convertedTime.trim();
    }

    public boolean isMilitary(String input){
        if(input.toLowerCase().contains("am")|input.toLowerCase().contains("pm")){
            return false;
        }
        return true;
    }

    private String trimLeadingZero(String input){
        if(input.substring(0,1).equals("0")){
            return input.substring(1);
        }
        return input;
    }

    public String askUserForInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to NumberConverter5000!!! Please enter a phone number or a time!");
        String input = scanner.nextLine();
        return input;

    }

    public String convertToWords(){
        String returnedString = "";
        String inputString = askUserForInput();
        if(checkIfPhoneNumber(inputString)){
            ArrayList<String> array = intFinder(inputString);
            returnedString = convertPhoneToWords(array);
        }
        else if(checkIfTime(inputString)){
            returnedString = convertTimeToWords(inputString);
        }
        else {
            returnedString = "Invalid entry";
        }
        return returnedString;
    }
}

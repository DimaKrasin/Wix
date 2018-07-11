package com.Wix;

import java.util.Map;

public class NumbersUtils {
    //Преобразование tralfamadorian число в десятичное
    public static Integer convertTralfamadorianToDecimal(String tralfamadorianNumber,String alphabetFileName) {

        FileUtils fileUtils =  new FileUtils();

        //Считываем алфавит из Alphabet.txt в Map
        Map<String, String> alphabet = fileUtils.readAlphabetAsMap(alphabetFileName);

        StringBuilder decimalAnswerInStringBuilder = new StringBuilder();

        //Нужно для расстановки чисел на правильное месте
        int lastUsedPlaceNumber = 0;
        int currentlyPlaceNumber = 0;

        if(tralfamadorianNumber.charAt(tralfamadorianNumber.length()-1) != '|'){
            currentlyPlaceNumber = 1;
        }

        //Проходим по всей строке ( Tralfamadorian Number )
        for (int i = tralfamadorianNumber.length() - 1; i >= 0; i--) {

            //Берем текуший символ
            char letter = tralfamadorianNumber.charAt(i);

            //Записываем на нужном месте
            if (alphabet.containsKey(String.valueOf(letter))) {

                if (currentlyPlaceNumber - lastUsedPlaceNumber >= 1) {
                    for (int j = 1; j < currentlyPlaceNumber - lastUsedPlaceNumber; j++) {
                        decimalAnswerInStringBuilder.append("0");
                    }

                }

                decimalAnswerInStringBuilder.append(alphabet.get(String.valueOf(letter)));
                lastUsedPlaceNumber = currentlyPlaceNumber;

                if(tralfamadorianNumber.charAt(tralfamadorianNumber.length()-1)!='|'){
                    currentlyPlaceNumber = 1;
                }else {
                    currentlyPlaceNumber = 0;
                }
            } else {
                if (letter == 'x') {
                    currentlyPlaceNumber = currentlyPlaceNumber + 2;
                }
                if (letter == '+') {
                    currentlyPlaceNumber = currentlyPlaceNumber + 1;
                }
            }
        }

        try {
            Integer.valueOf(decimalAnswerInStringBuilder.toString());
        }catch (NumberFormatException ex){
            return null;
        }

        return Integer.valueOf(decimalAnswerInStringBuilder.reverse().toString());
    }
}

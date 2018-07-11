package com.Wix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileUtils {

    //Считывает файл с алфавитом в Map <Символ алфавита(String),Порядковый номер этого символа(String)>
    public Map<String,String> readAlphabetAsMap(String alphabetFileName){

        Map<String,String> alphabet = new HashMap<String, String>();

        String[] charWithValueCouples = readFile(alphabetFileName).split("\n");

        for (String charWithValueCouple : charWithValueCouples) {
            String[] tmp = charWithValueCouple.split(" ");
            alphabet.put(tmp[0], tmp[1]);
        }

        return  alphabet;
    }

    private String readFile(String fileName){
        String result = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(fileName)))) {

            result = br.lines().collect(Collectors.joining("\n"));

        } catch (IOException ex) {
            //System.out.println(ex.getMessage());
        }

        return result;
    }
}

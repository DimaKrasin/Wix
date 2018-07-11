package JavFX;

import JavFX.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {

    public Map<String,String> readAlphabetAsMap(String alphabetFileName){

        Map<String,String> alphabet = new HashMap<String, String>();

        String[] charWithValueCouples = readFile(alphabetFileName).split("\n");

        for(int i=0;i<charWithValueCouples.length;i++){
            String[] tmp = charWithValueCouples[i].split(" ");
            alphabet.put(tmp[0],tmp[1]);
        }

        return  alphabet;
    }

    private  static String readFile(String fileName){

        String result = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream("Alphabet.txt")))) {
            result = br.lines().collect(Collectors.joining("\n"));
            result  = "kek";
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);

        return result;
    }


}

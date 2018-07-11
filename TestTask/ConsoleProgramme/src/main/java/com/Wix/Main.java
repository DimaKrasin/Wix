package com.Wix;

import java.util.Scanner;

public class Main {

    //Название файла с алфавитом
    //Можно редактировать файл (Соблюдая текущие правила)
    private static String alphabetFileName = "Alphabet.txt";

    public static void main(String[] args) {

        console();
    }

    //Выводи весь алфавит
    //Запрашиваем число в консоли
    //Расшифровываем его (переводим в десятичный вид)
    //Выводим результат в консоли
    private static void console() {

        //Вывести весь алфавит
        System.out.println();
        FileUtils fileUtils = new FileUtils();
        fileUtils.readAlphabetAsMap(alphabetFileName).forEach((k, v) -> {
            System.out.println(k + " - " + v + "; ");
        });

        System.out.println("\nAlphabet in '" + alphabetFileName + "', better to use this letters or add your own to file.\n");
        System.out.println("Enter your tralfamadorian Number:");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("You entered: " + input);

        //Вызываем методод для преобразования Вашей строки (Tralfamadorian числа) в  десятичное
        Integer result = NumbersUtils.convertTralfamadorianToDecimal(input, alphabetFileName);
        System.out.println("result: " + String.valueOf(result));
        System.out.println("If 'You entered' line have incorrect chars(like '?','  ++'), please change your encoding," +
                "\nor use english letters ( already in alphabet-file (a -1,b-2,c-3.....))" + "\nProgramme end.");
    }
}

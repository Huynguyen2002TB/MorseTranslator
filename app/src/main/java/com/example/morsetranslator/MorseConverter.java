package com.example.morsetranslator;

import java.util.HashMap;

public class MorseConverter {
    private static final HashMap<Character, String> textToMorse = new HashMap<>();
    private static final HashMap<String, Character> morseToText = new HashMap<>();

    static {
        String[][] morseTable = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                {"Z", "--.."}, {"0", "-----"}, {"1", ".----"}, {"2", "..---"},
                {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
                {"7", "--..."}, {"8", "---.."}, {"9", "----."}, {" ", "/"}
        };
        for( String [] entry : morseTable){
            textToMorse.put(entry[0].charAt(0), entry[1]);
            morseToText.put(entry[1], entry[0].charAt(0));

        }
    }
    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            String morseChar = textToMorse.get(c);
            morse.append((morseChar != null) ? morseChar + " " : "? ");
        }
        return morse.toString().trim();
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" / ");
        for (String word : words) {
            for (String c : word.split(" ")) {
                Character letter = morseToText.get(c);
                text.append((letter != null) ? letter : "?");
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
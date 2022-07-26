package anonymous_classes_interfaces_lambdas.mapping_example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Character;

public class MorseTranslator {

    Map<String, String> morseDict = Map.ofEntries(
            Map.entry(".-","a"),
            Map.entry("-...","b"),
            Map.entry("-.-.","c"),
            Map.entry("-..","d"),
            Map.entry(".","e"),
            Map.entry("..-.","f"),
            Map.entry("--.","g"),
            Map.entry("....","h"),
            Map.entry("..","i"),
            Map.entry(".---","j"),
            Map.entry("-.-","k"),
            Map.entry(".-..","l"),
            Map.entry("--","m"),
            Map.entry("-.","n"),
            Map.entry("---","o"),
            Map.entry(".--.","p"),
            Map.entry("--.-","q"),
            Map.entry(".-.","r"),
            Map.entry("...","s"),
            Map.entry("-","t"),
            Map.entry("..-","u"),
            Map.entry("...-","v"),
            Map.entry(".--","w"),
            Map.entry("-..-","x"),
            Map.entry("-.--","y"),
            Map.entry("--..","z"),
            Map.entry(".----","1"),
            Map.entry("..---","2"),
            Map.entry("...--","3"),
            Map.entry("....-","4"),
            Map.entry(".....","5"),
            Map.entry("-....","6"),
            Map.entry("--...","7"),
            Map.entry("---..","8"),
            Map.entry("----.","9"),
            Map.entry("-----","0"),
            Map.entry("/", " "));

    public MorseTranslator() {
        this.morseDict = morseDict;
    }

    public String translate(String input){

        String[] transList = input.split("/");
        List<String> translated = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (String i : transList){
            translated.add(morseDict.get(i));
        }

        for (String i : translated) {
            result.append(translated);
        }

        return result.toString();

    }



}

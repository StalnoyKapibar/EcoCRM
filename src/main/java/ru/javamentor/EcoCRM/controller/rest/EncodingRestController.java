package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/encoding")
public class EncodingRestController {

        @PostMapping("/1")
        public Map<Character, Integer> firstTask(@RequestParam("text") String text) throws UnsupportedEncodingException {
            text.replaceAll("\n","");
            text = clearSymbols(text);

            Map<Character, Integer> result = analyze(text).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            return result;
        }
        @PostMapping("/2")
        public Map<Character, Integer> secondTask(@RequestParam("text") String text) throws UnsupportedEncodingException {
            text.replaceAll("\n","");

            Map<Character, Integer> result = analyze(text).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            return result;
        }
        @PostMapping("/3")
        public Map<Character, Float> thirdTask(@RequestParam("text") String text) throws UnsupportedEncodingException {
            text = text.toUpperCase();
            text = text.replaceAll(" ","");
            text = clearSymbols(text);
            Map<Character, Integer> preResult = analyze(text).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            Map<Character, Float> result = new HashMap<>();
            for (Map.Entry<Character, Integer> entry : preResult.entrySet()) {
                result.put(entry.getKey(),(float)entry.getValue()/(float)text.length());
            }
            //сортировка с относительными частотами
            Map<Character,Float> relativeResult = result.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            return relativeResult;
        }

        //Непосредственно анализ текста
        public static Map<Character, Integer> analyze(String text){
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                map.merge(c, 1, (a, b) -> a + b);
            }
            return map;
        }
        //очистка от лишних символов
        private String clearSymbols(String text){
            text = text.replaceAll("\n","");
            text = text.replaceAll("[-.?!)(,:;\"\']","");
            text = text.replaceAll("/[0-9]/","");
            text = text.replaceAll("0","");
            text = text.replaceAll("1","");
            text = text.replaceAll("2","");
            text = text.replaceAll("3","");
            text = text.replaceAll("4","");
            text = text.replaceAll("5","");
            text = text.replaceAll("6","");
            text = text.replaceAll("7","");
            text = text.replaceAll("8","");
            text = text.replaceAll("9","");
            return text;
        }
        @PostMapping("/5")
        public Map<Character, Integer> fifthTask(@RequestParam("text") String text) throws UnsupportedEncodingException {
            text.replaceAll("\n","");
//            text = clearSymbols(text);

            Map<Character, Integer> result = analyze(text).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            return result;
        }


}

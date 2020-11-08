package com.example.demo.controller;

import com.example.demo.domain.Currency;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CurrencyCalculator {
    
    
    @PostMapping("/currency")
    Map<String,Integer> calculateCurrency(@RequestBody ArrayList<Currency> list){
        Map<String,Integer> result= new HashMap<>();
        for(Currency c:list){
            result.put(c.getCurrency(),result.getOrDefault(c.getCurrency(),0)+c.getAmount());
        }
        sortByValue(result);
        return result;
    }
    public static Map<String, Integer> sortByValue(Map<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hm.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}

package com.mycontactapp.contact.tag;

import java.util.HashMap;
import java.util.Map;

public class TagFactory {

    private static Map<String,Tag> cache = new HashMap<>();

    public static Tag getTag(String name){

        String key = name.toLowerCase();

        if(!cache.containsKey(key)){

            cache.put(key,new Tag(key));

        }

        return cache.get(key);
    }
}
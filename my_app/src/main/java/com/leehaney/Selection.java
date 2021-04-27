package com.leehaney;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Selection {
    
    static List<Quote> quotes = new ArrayList<Quote>();

    static void start_program() {
        
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            InputStream input_stream = classLoader.getResourceAsStream("quotes.json");
            
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(input_stream));

            JSONArray my_array = (JSONArray) jsonObject.get("quotes_list");
            
            create_quotes(my_array);
            


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    } 

    static void create_quotes(JSONArray my_array) {
        
        for(Object quote : my_array)
        {
            JSONObject quoteJSON = (JSONObject)quote;
            quotes.add(new Quote(quoteJSON.get("quote").toString(), 
                                 quoteJSON.get("source").toString(),
                                 quoteJSON.get("citation").toString(),
                                 quoteJSON.get("year").toString()));
        }
        
    } 

    static int get_random_index() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(quotes.size());

        return randomIndex;
        
    } 

}
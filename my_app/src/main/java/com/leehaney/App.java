package com.leehaney;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Selection.start_program();

        get("/", (req, res) -> {
            int randomIndex = Selection.get_random_index();
            Quote current_quote_object = Selection.quotes.get(randomIndex);

            Map<String, String> model = new HashMap<String, String>();
            model.put("quote", current_quote_object.getQuote());
            model.put("source", current_quote_object.getSource());
            model.put("citation", current_quote_object.getCitation());
            model.put("year", current_quote_object.getYear());

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

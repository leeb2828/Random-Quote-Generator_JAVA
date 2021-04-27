package com.leehaney;

public class Quote {
    private String quote;
    private String source;
    private String citation;
    private String year;

    public Quote(String quote, String source, String citation, String year) {
        this.quote = quote;
        this.source = source;
        this.citation = citation;
        this.year = year;
    }

    public String getQuote() {
        return quote;
    }

    public String getSource() {
        return source;
    }

    public String getCitation() {
        return citation;
    }

    public String getYear() {
        return year;
    }

    public String toString() {
        return quote + "\n" + source + "\n" + citation + "\n" + year;
    }
    
}
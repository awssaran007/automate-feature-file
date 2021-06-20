package org.example;

public class Url {

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }



    public Query[] getQuery() {
        return query;
    }

    public void setQuery(Query[] query) {
        this.query = query;
    }

    String raw;

    Query[] query;

}

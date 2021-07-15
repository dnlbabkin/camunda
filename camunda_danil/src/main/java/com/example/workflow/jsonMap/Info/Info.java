package com.example.workflow.jsonMap.Info;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {
    @JsonProperty
    private String seed;

    @JsonProperty
    private int results;

    @JsonProperty
    private int page;

    @JsonProperty
    private String version;

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "seed='" + seed + '\'' +
                ", results=" + results +
                ", page=" + page +
                ", version='" + version + '\'' +
                '}';
    }
}

package com.example.workflow.jsonMap;

import camundajar.impl.scala.collection.immutable.List;
import com.example.workflow.jsonMap.Info.Info;
import com.example.workflow.jsonMap.results.Results;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MappingJson {
    @JsonProperty
    private Results[] results;

    @JsonProperty
    private Info info;

    public Results getResults() {
        return results[0];
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MappingJson{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }
}

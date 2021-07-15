package com.example.workflow.jsonMap.results.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timezone {
    @JsonProperty
    private String offset;

    @JsonProperty
    private String description;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "offset='" + offset + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

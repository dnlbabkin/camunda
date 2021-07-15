package com.example.workflow.fuckUp;

import camundajar.impl.scala.collection.immutable.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import javax.management.ObjectName;
import java.lang.reflect.Array;
import java.util.Arrays;


public class ParserFUP {

    @JsonProperty
    private String[] definition_keys;

    public String[] getDefinition_keys() {
        return definition_keys;
    }

    public void setDefinition_keys(String[] definition_keys) {
        this.definition_keys = definition_keys;
    }

    @Override
    public String toString() {
        return "ParserFUP{" +
                "definition_keys=" + Arrays.toString(definition_keys) +
                '}';
    }
}

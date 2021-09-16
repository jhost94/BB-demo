package com.backbase.training.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This is to decode message to JSON, I think
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pogo")
@JsonPropertyOrder({
        "message"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    @JsonProperty("id")
    @NotNull
    private String id;

    @JsonProperty("message")
    @NotNull
    @Size(max = 255)
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

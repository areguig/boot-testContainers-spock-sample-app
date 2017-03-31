package io.areguig.sample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by akli on 31/03/2017.
 */
@Data
public class Character {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String show;
}

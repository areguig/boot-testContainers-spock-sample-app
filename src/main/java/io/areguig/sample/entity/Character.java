package io.areguig.sample.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by akli on 31/03/2017.
 */
@Data
public class Character {

    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String showName;
}

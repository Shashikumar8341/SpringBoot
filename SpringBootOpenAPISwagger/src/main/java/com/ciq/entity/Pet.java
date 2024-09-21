package com.ciq.entity;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
@Schema(discriminatorProperty = "type", oneOf = {Dog.class, Cat.class},
        discriminatorMapping = {
                @DiscriminatorMapping(value = "dog", schema = Dog.class),
                @DiscriminatorMapping(value = "cat", schema = Cat.class)
        })

public  class Pet {
    @Schema(description = "Name of the pet", example = "Max")
    public String name;

    @Schema(description = "Type of the pet", example = "dog")
    public String type;
}

@Schema(description = "Dog entity")
class Dog extends Pet {
    @Schema(description = "Breed of the dog", example = "Labrador")
    public String breed;
}

@Schema(description = "Cat entity")
class Cat extends Pet {
    @Schema(description = "Color of the cat", example = "Black")
    public String color;
}

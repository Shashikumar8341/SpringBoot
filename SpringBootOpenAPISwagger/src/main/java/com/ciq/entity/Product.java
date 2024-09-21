package com.ciq.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat"),
        @JsonSubTypes.Type(value = Pet.class, name = "pet")
})
@Schema(description = "Product entity",discriminatorProperty = "type", oneOf = {Dog.class, Cat.class,Pet.class},
        discriminatorMapping = {
                @DiscriminatorMapping(value = "dog", schema = Dog.class),
                @DiscriminatorMapping(value = "cat", schema = Cat.class),
                @DiscriminatorMapping(value = "pet", schema = Pet.class)
        })

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Schema(description  = "product of the name",example  = "json")
	private String name;
	private double price;
	private String description;

}
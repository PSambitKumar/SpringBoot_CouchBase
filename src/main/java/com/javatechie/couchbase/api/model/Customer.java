package com.javatechie.couchbase.api.model;

import lombok.Generated;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	private int id;
	@Field
	private String name;
	@Field
	private String[] address;

}

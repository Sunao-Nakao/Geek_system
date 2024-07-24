package com.example.demo.entity.converter;

import com.example.demo.constant.Permissions;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PermissionsConverter implements AttributeConverter<Permissions, String> {
	
	@Override
	public String convertToDatabaseColumn(Permissions Permissions) {
		return Permissions.getCode();
	}
	
	
	public Permissions convertToEntityAttribute(String value) {
		return Permissions.from(value);
	}

}

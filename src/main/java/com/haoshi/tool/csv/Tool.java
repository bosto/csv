package com.haoshi.tool.csv;

import java.lang.reflect.Field;

public class Tool {
	public static String getBindColumn(Field field) {
		CsvColumn  csvColumn = field.getAnnotation(CsvColumn.class);
		String name = csvColumn.name();
		return name.equals("") ? field.getName() : name;
	}
}

package com.haoshi.tool.csv;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class Bean<T> {
    private static String COMMA = ",";
    private static String ENTER = "\n";
    
    
    List<T> array;

    public Bean(List<T> array) throws CSVException {
        this.array = array;
        if (array == null || array.size() == 0)
            throw new CSVException("Array is empty!");
    }

    public void toCSV(String filePath) throws Exception {
        FileWriter fileWriter = new FileWriter(filePath);
        List<Field> fields = Arrays.asList(array.get(0).getClass().getDeclaredFields()).stream()
            .filter(field -> field.isAnnotationPresent(CsvColumn.class)).collect(Collectors.toList());
        
        // set accessiable
        fields.forEach(field -> {
            field.setAccessible(true);
        });
        
        // set header
        StringBuilder sb = new StringBuilder();
        sb.append(fields.stream().map(field -> field.getName())
            .collect(Collectors.joining(COMMA)));
        sb.append(
        array.stream().map(entity -> {
            String row = fields.stream().map((field) -> 
            { 
                String value = "";
                try {
                    value =  field.get(entity).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        fileWriter.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                return value;
            }
            ).collect(Collectors.joining(COMMA));
            return row;
        }).collect(Collectors.joining(ENTER))
        );
        
        fileWriter.write(sb.toString());
        fileWriter.close();
    }
}

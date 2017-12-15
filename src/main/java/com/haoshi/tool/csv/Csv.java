package com.haoshi.tool.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class Csv<T> {
    private BufferedReader readFile;
    private HashMap<String, Integer> headerIndexMap = new HashMap<String, Integer>();
    private AtomicInteger index = new AtomicInteger(0);

    public Csv(FileReader readFile) throws IOException {
        this.readFile = new BufferedReader(readFile);
        initHeaderIndexMap();
    }

    public List<T> into(Class<? extends T> type) throws Exception {
        ArrayList<T> array = new ArrayList<T>();
        List<Field> fields = Arrays.asList(type.getDeclaredFields());
        List<Field> fieldsFiltered = fields.stream()
            .filter(field -> field.isAnnotationPresent(CsvColumn.class) && headerIndexMap.containsKey(field.getName()))
            .collect(Collectors.toList());
        String line = null;
        while ((line = readFile.readLine()) != null) {
            String[] row = line.split(",");
            if (row.length > 0) {
                T instance = type.newInstance();
                fieldsFiltered.forEach(
                    field -> {
                        try {
                        field.setAccessible(true);
                        field.set(instance, row[headerIndexMap.get(field.getName())]);
                        } catch (Exception e) {
                            try {
                                throw e;
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                array.add(instance);
            }
        }
        return array;

    }

    public void initHeaderIndexMap() throws IOException {
        List<String> headers = Arrays.asList(readFile.readLine().split(","));
        headers.stream().forEach(header -> headerIndexMap.put(header, index.getAndAdd(1)));
    }
}

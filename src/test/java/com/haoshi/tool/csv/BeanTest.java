/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2017. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of HSBC Holdings plc.
 */
package com.haoshi.tool.csv;

import java.io.FileReader;
import java.util.List;

import org.junit.Test;

/**
 * <p><b>
 * TODO : Insert description of the class's responsibility/role.
 * </b></p>
 */
public class BeanTest {
    
    @Test
    public void BeanToCsv() throws Exception {
        Csv<Person> csv = new Csv<Person>(
            new FileReader(Csv.class.getResource("person.csv")
                .getPath()));
        List<Person> persons = csv.into(Person.class);
        String filePath = "C:\\Users\\43929293\\Desktop\\persons.csv";
        Bean<Person> bean = new Bean<Person>(persons);
        bean.toCSV(filePath);
    }

}

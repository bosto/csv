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

/**
 * <p><b>
 * TODO : Insert description of the class's responsibility/role.
 * </b></p>
 */
public class Person {
    @CsvColumn(name="test_name")
    private String name;
    @CsvColumn
    private String sex;
    @CsvColumn
    private String age;
    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the sex
     */
    public String getSex() {
        return this.sex;
    }
    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * @return the age
     */
    public String getAge() {
        return this.age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
    /**
     * <p><b>
     * TODO : Insert description of the method's responsibility/role.
     * </b></p>
     *
     * @param name
     * @param sex
     * @param age
     */
    public Person(String name, String sex, String age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    /**
     * <p><b>
     * TODO : Insert description of the method's responsibility/role.
     * </b></p>
     *
     */
    public Person() {
        super();
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.age == null) ? 0 : this.age.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.sex == null) ? 0 : this.sex.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (this.age == null) {
            if (other.age != null)
                return false;
        } else if (!this.age.equals(other.age))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        if (this.sex == null) {
            if (other.sex != null)
                return false;
        } else if (!this.sex.equals(other.sex))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Person [name=" + this.name + ", sex=" + this.sex + ", age=" + this.age + "]";
    }
    
}

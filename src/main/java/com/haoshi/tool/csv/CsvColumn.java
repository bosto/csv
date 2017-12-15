package com.haoshi.tool.csv;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p><b>
 * TODO : Insert description of the class's responsibility/role.
 * </b></p>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CsvColumn {
    String type() default "String";
    
    // default the same with field name
    String bindColumn() default "";
}

package org.andestech.learning.rfb18.g2;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Logger {

LoggingLevel level() default LoggingLevel.Off;

LoggingDestination[] dest() default {LoggingDestination.WindowsEventLog};

//

}

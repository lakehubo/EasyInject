package com.lake.easyinject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * this annotation use to create singleton class.
 * new Singleton class will be named original class name with _Single.
 * for example:
 * before class name is MyObject,the new singleton class name will be
 * MyObject_Single.
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Singleton {
    SingletonType value() default SingletonType.DLC;
}

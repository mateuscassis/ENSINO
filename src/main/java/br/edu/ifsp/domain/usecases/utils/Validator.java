package br.edu.ifsp.domain.usecases.utils;

import java.util.Collection;

public abstract class Validator<T> {
    public abstract Notifications validate(T type);

    public static boolean nullOrEmpty(String string){
        return string == null || string.isEmpty();
    }

    public static boolean nullOrEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }
}

package br.com.codethebasics.converter;

public interface Converter<T, I> {

    /**
     * T -> From
     * I -> To
     */
    I convert(T t);

}

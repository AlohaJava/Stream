package com.company.Stream;

import java.util.*;
import java.util.function.*;

public class mStream<T> {
    private final List<T> data;

    @SafeVarargs
    public static<T> mStream<T> of(T... elements) {
        return new mStream<T>(Arrays.asList(elements));
    }

    private mStream(List<? extends T> data) {
        this.data = new ArrayList<T>(data);
    }

    public void forEach(Consumer<? super T> consumerMethod) {
        for (T elem : data) {
            consumerMethod.accept(elem);
        }
    }

    public mStream<T> filter (Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T elem : data) {
            if (predicate.test(elem)) {
                result.add(elem);
            }
        }
        return new mStream<T>(result);
    }

    public<V> mStream<V> map(Function<? super T, ? extends V> mapper) {
        List<V> newList = new ArrayList<>();
        for (T element : data) {
            newList.add(mapper.apply(element));
        }
        return new mStream<V>(newList);
    }

    public mStream<T> distinct() {
        return new mStream<T>( new ArrayList<T>(new LinkedHashSet<T>(data)));
    }

}
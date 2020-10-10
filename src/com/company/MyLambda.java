package com.company;

@FunctionalInterface
public interface MyLambda<T> {
    T getSum(T a, T b);
}

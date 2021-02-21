package com.zww.testrpc.example;

/**
 * @author zww
 * @date 2021/2/21 15:03
 */

public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}

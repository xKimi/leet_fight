package com.kimi.leetfight.reverse_number_0007;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/8/25 16:47
 * @Author Feng Yalong
 */
public class ReverseNumber {
    public int reverse(int x) {
        // todo 暴力解法，需要优化
        char[] xArray = String.valueOf(x).toCharArray();
        boolean isPositive = false;
        if (xArray[0] == ('-')) {
            isPositive = true;
        }
        int length = xArray.length;
        char temp;
        if (isPositive) {
            for (int i = 1; i < length - 1; i++) {
                if ((length % 2 == 0 && i > length / 2) || (length % 2 == 1 && i == (length + 1) / 2 )) {
                    break;
                }
                temp = xArray[i];
                xArray[i] = xArray[length - i];
                xArray[length - i] = temp;
            }
        } else {
            for (int i = 0; i < length; i++) {
                if ((length % 2 == 0 && i >= length / 2) || (length % 2 == 1 && i == (length + 1) / 2 )) {
                    break;
                }
                temp = xArray[i];
                xArray[i] = xArray[length - 1 - i];
                xArray[length - 1 - i] = temp;
            }
        }

        return (Long.valueOf(String.valueOf(xArray)) > Integer.MAX_VALUE || Long.valueOf(String.valueOf(xArray)) < Integer.MIN_VALUE) ? 0 : Integer.valueOf(String.valueOf(xArray));
    }
}

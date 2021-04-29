package com.home.common;

import com.home.common.maths.MathsUtils;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;


public class MathsUtilsTest {
    @Test
    public void findPrimesOf_happyPath() {
        MathsUtils mathsUtils = new MathsUtils();

        List<Integer> result = mathsUtils.findPrimesOf(4);

        System.out.println(result.toString());

        Assertions.assertThat(result.size()).isEqualTo(6);
        Assertions.assertThat(result).contains(2, 3, 5, 7, 11, 13);
    }
}

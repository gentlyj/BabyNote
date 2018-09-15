package com.ifading.babynote.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created  on 20180915//.
 *
 * @author by yangjingsheng
 */
public class PatternUtilTest {

    @Test
    public void matchEmail() {
        String a = "1231231231231";
        String b = "1231231231231@sian";
        String c = "123123asdas@sina.com";

        assertEquals(PatternUtil.matchEmail(a),false);
        assertEquals(PatternUtil.matchEmail(b),false);




        assertEquals(true,PatternUtil.matchEmail(c));

    }
}
package com.tencent.cd.lazydog.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lara on 2017/5/30.
 */
public class MyClassTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetPublicStaticString() throws Exception {
        String str = "hello";
        assertEquals(str, MyClass.getPublicStaticString(str));
    }

    @Test
    public void testGetPublicString() throws Exception {
        MyClass myClass = new MyClass();
        String str = "hello";
        assertEquals(str, myClass.getPublicString(str));
    }

    @Test
    public void testGetPrivateString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MyClass myClass = new MyClass();
        Method privateMethod = myClass.getClass().getDeclaredMethod("getPrivateString", String.class);
        privateMethod.setAccessible(true);
        String str = "hello";
        Object obj = privateMethod.invoke(myClass, str);
        assertEquals(str, obj);
    }

    @Test
    public void testGetPrivateStaticString() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method privateStaticMethod = MyClass.class.getDeclaredMethod("getPrivateStaticString", String.class);
        privateStaticMethod.setAccessible(true);
        String str = "hello";
        Object obj = privateStaticMethod.invoke(MyClass.class, str);
        assertEquals(str, obj);
    }
}
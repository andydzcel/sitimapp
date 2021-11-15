package com.example.sitimappcolombia.clases;

import com.example.sitimappcolombia.login;

import junit.framework.TestCase;

public class PruebasUnitariasTest extends TestCase {

    public void testCamposVacios()
    {
        assertEquals(true, login.camposVacios("",""));
    }
}
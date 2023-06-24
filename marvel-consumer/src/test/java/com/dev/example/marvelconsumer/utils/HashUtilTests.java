package com.dev.example.marvelconsumer.utils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
* @author Mauricio González
* 
*/
public class HashUtilTests {

    @BeforeEach                                         
    void setUp() {
    }

    @Test                                               
    @DisplayName("Pruebas para la función HashUtil")   
    void testHash() {
        assertAll("Función getHash en clase HashUtil",
            () -> assertNotNull(HashUtil.getHash("EXAMPLEHASH", HashType.MD5), "El hash no debería ser null"),
            () -> assertEquals("765d40b734060a914b1a6184f6563d47", HashUtil.getHash("EXAMPLEHASH", HashType.MD5),
                "El hash debería ser 765d40b734060a914b1a6184f6563d47")
        );
    }
}

/*
 * Copyright 2017 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package csd4464.json.samples;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class ProductTest {

    Product globalInstance;

    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        globalInstance = new Product();
        globalInstance.setId("ABC123456");
        globalInstance.setName("Product Name");
        globalInstance.setQuantity(15);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNoArgConstructorSetsValuesCorrectly() {
        Product instance = new Product();
        String expId = "";
        String expName = "";
        int expQuantity = 0;
        assertEquals(expId, instance.getId());
        assertEquals(expName, instance.getName());
        assertEquals(expQuantity, instance.getQuantity());
    }

    @Test
    public void testFullConstructorSetsValuesCorrectly() {
        Product instance = new Product("ABC123456", "Product Name", 15);
        String expId = "ABC123456";
        String expName = "Product Name";
        int expQuantity = 15;
        assertEquals(expId, instance.getId());
        assertEquals(expName, instance.getName());
        assertEquals(expQuantity, instance.getQuantity());
    }

    @Test
    public void testSettersAndGettersApplyValuesCorrectly() {
        Product instance = new Product();
        instance.setId("ABC123456");
        instance.setName("Product Name");
        instance.setQuantity(15);
        String expId = "ABC123456";
        String expName = "Product Name";
        int expQuantity = 15;
        assertEquals(expId, instance.getId());
        assertEquals(expName, instance.getName());
        assertEquals(expQuantity, instance.getQuantity());
    }
    
    @Test
    public void testToStringGivesValidJSON() {
        try {
            Product instance = new Product();
            instance.setId("ABC123456");
            instance.setName("Product Name");
            instance.setQuantity(15);
            String jsonString = "{\"id\":\"ABC123456\",\"name\":\"Product Name\",\"quantity\":15}";
            JSONObject expJson = (JSONObject) (new JSONParser()).parse(jsonString);
            String expString = expJson.toJSONString();
            String result = instance.toString();
            assertEquals(expString, result);
        } catch (ParseException ex) {
            fail("JSON Parsing Error: " + ex.getMessage());
        }
    }

}

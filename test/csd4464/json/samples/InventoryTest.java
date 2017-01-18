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

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
public class InventoryTest {
    
    private Inventory globalInstance;
    
    public InventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        globalInstance = new Inventory();
        globalInstance.add(new Product("AAA111", "A", 1));
        globalInstance.add(new Product("AAA222", "B", 2));
        globalInstance.add(new Product("AAA333", "C", 0));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddOneAndGetFirstProducesSameResult() {
        Inventory instance = new Inventory();
        Product p = new Product("AAA111", "A", 1);
        instance.add(p);
        Product expResult = new Product("AAA111", "A", 1);
        Product result = instance.get(0);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoAndGetSecondProducesSecondResult() {
        Inventory instance = new Inventory();
        Product p1 = new Product("AAA111", "A", 1);
        instance.add(p1);
        Product p2 = new Product("AAA222", "B", 2);
        instance.add(p2);
        Product expResult = new Product("AAA222", "B", 2);
        Product result = instance.get(1);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddOneAndGetByIDProducesCorrectResult() {
        Inventory instance = new Inventory();
        Product p1 = new Product("AAA111", "A", 1);
        instance.add(p1);
        Product expResult = new Product("AAA111", "A", 1);
        Product result = instance.getById("AAA111");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringProducesExpectedJSON() {
        JsonParser parser = new JsonParser();
        String jsonString = globalInstance.toString();
        String expString = "[{\"quantity\":1,\"name\":\"A\",\"id\":\"AAA111\"}," + 
                "{\"name\":\"B\",\"quantity\":2,\"id\":\"AAA222\"}," + 
                "{\"name\":\"C\",\"id\":\"AAA333\",\"quantity\":0}]";
        JsonElement expJson = parser.parse(expString);
        JsonElement resultJson = parser.parse(jsonString);
        assertEquals(expJson, resultJson);
    }
    
}

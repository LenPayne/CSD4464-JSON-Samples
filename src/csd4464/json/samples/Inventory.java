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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class Inventory {

    private List<Product> products;

    /**
     * Constructor which accepts an already-created List of Products
     *
     * @param products the List of Products
     */
    public Inventory(List<Product> products) {
        this.products = products;
    }

    /**
     * Constructor that creates an empty List of Products
     */
    public Inventory() {
        products = new ArrayList<>();
    }

    /**
     * Constructor that accepts a JSON String
     *
     * @param json the JSON String
     */
    public Inventory(String json) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = (JsonArray) parser.parse(json);
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            products.add(new Product(jsonObject.toString()));
        }
    }

    /**
     * Add a Product to the List
     *
     * @param p the Product
     */
    public void add(Product p) {
        products.add(p);
    }

    /**
     * Retrieve the Product at an Index
     *
     * @param i the Index
     * @return the Product
     */
    public Product get(int i) {
        return products.get(i);
    }

    /**
     * Retrieve the Product by its ID
     *
     * @param id the ID
     * @return the Product
     */
    public Product getById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Produce a JSON String of the Products List
     *
     * @return the JSON String
     */
    @Override
    public String toString() {
        JsonArray jsonArray = new JsonArray();
        JsonParser parser = new JsonParser();
        for (Product p : products) {
            JsonElement jsonObj = parser.parse(p.toString());
            jsonArray.add(jsonObj);
        }
        return jsonArray.toString();
    }
}

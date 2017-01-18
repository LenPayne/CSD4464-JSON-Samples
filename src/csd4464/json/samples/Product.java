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

import java.util.Objects;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class Product {

    private String id;
    private String name;
    private int quantity;

    /**
     * No-Arg Constructor Sets Defaults
     */
    public Product() {
        id = "";
        name = "";
        quantity = 0;
    }

    /**
     * Constructor accepts a JSON string as an argument
     * @param json a JSON formatted String
     */
    public Product(String json) {
        try {
            JSONObject jsonObj = (JSONObject) (new JSONParser().parse(json));
            id = (String) jsonObj.get("id");
            name = (String) jsonObj.get("name");
            quantity = (int) jsonObj.get("quantity");
        } catch (ParseException ex) {
            id = "";
            name = "";
            quantity = 0;
        }
    }

    /**
     * Constructor that accepts the product parameters
     * @param id the ID
     * @param name the Name
     * @param quantity the Quantity
     */
    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Retrieve the ID
     * @return the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID
     * @param id the ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieve the Name
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Name
     * @param name the Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the Quantity
     * @return the Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the Quantity
     * @param quantity the Quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieve the HashCode
     * @return the HashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + this.quantity;
        return hash;
    }

    /**
     * Compare Equality between Two Product Objects
     * @param obj the other Product
     * @return whether the two Products are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * Produce a JSON String with the required format
     * @return the JSON String
     */
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        json.put("quantity", quantity);
        return json.toJSONString();
    }

}

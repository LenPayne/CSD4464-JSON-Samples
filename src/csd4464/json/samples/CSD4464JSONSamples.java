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

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class CSD4464JSONSamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventory sampleInventory = new Inventory();
        sampleInventory.add(new Product("AAA111", "A", 1));
        sampleInventory.add(new Product("AAA222", "B", 2));
        sampleInventory.add(new Product("AAA333", "C", 0));
        
        System.out.println("Sample Inventory: ");
        System.out.println(sampleInventory);
        
        System.out.println("2nd Product in Inventory");
        System.out.println(sampleInventory.get(1));
        
        System.out.println("Details for Product ID AAA333");
        System.out.println(sampleInventory.getById("AAA333"));
    }
    
}

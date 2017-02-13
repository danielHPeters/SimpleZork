/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.items;

import zork.interfaces.IUseable;

/**
 *
 * @author d.peters
 */
public class AxeAction implements IUseable {

    @Override
    public void use() {
        System.out.println("You swing the Axe at your enemy.");
    }
    
}

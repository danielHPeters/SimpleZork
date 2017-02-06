/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.entities;

/**
 *
 * @author d.peters
 */
public class Entity {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private int age;

    /**
     *
     * @param name
     * @param age
     */
    public Entity(String name, int age) {

        this.name = name;
        this.age = age;

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

}

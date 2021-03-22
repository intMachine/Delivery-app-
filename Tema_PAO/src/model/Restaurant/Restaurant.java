package model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static int global_id = 0;
    private int id;
    private String name;
    private ArrayList<Dish> menu;
    private int category_level;

    public Restaurant(String name, ArrayList<Dish> menu, int category_level){
        global_id += 1;
        this.id = global_id;
        this.name = name;
        this.menu = menu;
        this.category_level = category_level;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", menu=" + menu +
                ", category_level=" + category_level +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Dish> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Dish> menu) {
        this.menu = menu;
    }

    public int getCategory_level() {
        return category_level;
    }

    public void setCategory_level(int category_level) {
        this.category_level = category_level;
    }
}

package model.Restaurant;

import java.util.ArrayList;

public class Dish {

    private static int global_id = 0;
    private int id;
    private String name;
    private ArrayList <Ingredient> ingredients;
    private float price;
    private String description;

    public Dish(String name, ArrayList<Ingredient> ingredients, float price, String description){
        global_id += 1;
        this.id = global_id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
//
//    public Dish getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

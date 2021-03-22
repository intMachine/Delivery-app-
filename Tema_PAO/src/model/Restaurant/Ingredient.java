package model.Restaurant;

public class Ingredient {

    private int global_id = 0;
    private int id;
    private String name;
    private boolean inTerm;

    public Ingredient(String name, boolean inTerm){
        global_id += 1;
        this.id = global_id;
        this.name = name;
        this.inTerm = inTerm;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inTerm=" + inTerm +
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

    public boolean isInTerm() {
        return inTerm;
    }

    public void setInTerm(boolean inTerm) {
        this.inTerm = inTerm;
    }
}

package repository;

import config.DatabaseConnection;
import model.Restaurant.Ingredient;
import model.User.Customer;
import model.User.Driver;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private static IngredientRepository instance = null;
    private IngredientRepository(){}

    public static IngredientRepository getInstance() {
        if(instance == null){
            instance = new IngredientRepository();
        }
        return instance;
    }

    public void addIngredient(Ingredient ingredient){

        String sql = "insert into ingredient ( name, inTerm ) VALUES ( ?, ?)";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, ingredient.getName());
            statement.setString(2, String.valueOf(ingredient.isInTerm()));
            statement.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Ingredient getIngredient(int ingId){
        String sql = "select * from ingredient where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setString(1, String.valueOf(ingId));
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String name = result.getString(2);
                boolean inTerm = Boolean.parseBoolean(result.getString(3));
                Ingredient ingredient = new Ingredient( name, inTerm);
                return ingredient;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Ingredient> getIngredient(){
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "select * from ingredient";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String id = result.getString(1);
                String name = result.getString(2);
                boolean inTerm = Boolean.parseBoolean(result.getString(3));
                ingredients.add(new Ingredient(name, inTerm));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  ingredients;
    }

    public void updateIngredient(int id, Ingredient ingredient){
        String sql = "update ingredient " +
                "set name = ?," +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            statement.setInt(3 , id);
            statement.setString(1, ingredient.getName());
            statement.setString(2, String.valueOf(ingredient.isInTerm()));

            statement.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteIngredient(int id){
        String sql = "delete from ingredient " +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
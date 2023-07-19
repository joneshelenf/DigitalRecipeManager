package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe extends AbstractEntity{

//    private int id;
//    private static int nextId = 1;
    private String name;
    private String description;
    private String contactEmail;
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();
    private MealType mealType;
    private DietType dietType;
    private CuisineType cuisineType;
    private int cookingTime;



    public Recipe(String name, String description,String contactEmail, MealType mealType,
                  CuisineType cuisineType, DietType dietType, int cookingTime) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.mealType = mealType;
        this.cuisineType = cuisineType;
        this.dietType = dietType;
        this.cookingTime = cookingTime;

    }

    public Recipe() {
//        this.id = nextId;
//        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

//    public int getId() {
//        return id;
//    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }


    public List<Ingredient> getIngredients() {

        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Recipe recipe = (Recipe) o;
//        return id == recipe.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}





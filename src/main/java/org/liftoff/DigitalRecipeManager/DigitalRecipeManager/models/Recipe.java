package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity  {
    @Size(min=3, max=50, message= "Name must be between 3 and 50 characters!")
    @NotBlank(message = "Name is required!")
    private String name;
    @Size(max=500, message= "Description is too long!")
    @NotBlank(message = "Description is required!")
    private String description;
    //@Email(message = "Invalid email.Try again!")
    //@NotBlank(message = "Email is required!")
    //private String contactEmail;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeMeasurement> ingredients;
    private MealType mealType;
    private DietType dietType;
    private CuisineType cuisineType;
    @NotNull(message= "Cooking time is required!")
    private int cookingTime;
    @Size(min=10, max=500, message= "instructions must be between 10 and 500 characters")
    @NotBlank(message= "Instructions is required!")
    private String instructions;
    @Size(min=3, max=50)
    @NotBlank(message= "Required!")
    private String createdBy;
    private String measurement;

    public Recipe(String name, String description, List<RecipeMeasurement>ingredients,
                  MealType mealType, DietType dietType,CuisineType cuisineType,
                  int cookingTime, String instructions, String createdBy, String measurement ) {
        this.name = name;
        this.description = description;
        //this.contactEmail = contactEmail;
        this.ingredients = ingredients;
        this.mealType = mealType;
        this.cuisineType = cuisineType;
        this.dietType = dietType;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
        this.createdBy = createdBy;
        this.measurement = measurement;
    }

    public Recipe() {}

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

    /*public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }*/

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

    public List<RecipeMeasurement> getIngredients() {

        return ingredients;
    }

    public void setIngredients(List<RecipeMeasurement> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return name;
    }
}





package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.controllers;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.IngredientRepository;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.RecipeData;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.CuisineType;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.DietType;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.MealType;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Recipe;
import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("")
    public String displayAllRecipes(Model model)    {
        model.addAttribute("title","All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }
    @GetMapping("create")
    public String displayCreateRecipeForm(Model model)  {
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("mealTypes", MealType.values());
        model.addAttribute("cuisineTypes", CuisineType.values());
        model.addAttribute("dietTypes", DietType.values());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "recipes/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute Recipe newRecipe, Model model)    {

        model.addAttribute("title", "Create Recipe");
        recipeRepository.save(newRecipe);
        return "redirect:";
    }
    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model)   {
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/delete";
    }
    @PostMapping("delete")
    public String processDeleteRecipesForm(@RequestParam(required = false) int[] recipeIds)   {
        if  (recipeIds != null) {
            for (int id : recipeIds) {
                RecipeData.remove(id);
            }
        }
        return "redirect:";
    }
    @GetMapping("edit/{recipeId}")
    public String displayEditRecipeForm(Model model, @PathVariable int recipeId) {
        Recipe  recipeToEdit = RecipeData.getById(recipeId);
        String title = "Edit Recipe " + recipeToEdit.getName() + " (id=" + recipeToEdit.getId() + ")";
        model.addAttribute("title", title );
        model.addAttribute("recipe", recipeToEdit);
        return "recipes/edit";
    }
    @PostMapping("edit")
    public String processEditRecipeForm(int recipeId, String name, String description,String contactEmail) {
        Recipe recipeToEdit = RecipeData.getById(recipeId);
        recipeToEdit.setName(name);
        recipeToEdit.setDescription(description);
        recipeToEdit.setContactEmail(contactEmail);
        //recipeToEdit.setIngredients(ingredients);
        //recipeToEdit.setCookingTime(cookingTime);
        return "redirect:";
    }

}


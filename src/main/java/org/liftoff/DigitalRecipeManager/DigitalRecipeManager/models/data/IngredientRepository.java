package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.data;

import org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}

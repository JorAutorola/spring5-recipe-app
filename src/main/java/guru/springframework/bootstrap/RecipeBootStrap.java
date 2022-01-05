package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent>
{
  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;
  private final RecipeRepository recipeRepository;

  public RecipeBootStrap(CategoryRepository _categoryRepository, UnitOfMeasureRepository _unitOfMeasureRepository,
                         RecipeRepository _recipeRepository)
  {
    categoryRepository = _categoryRepository;
    unitOfMeasureRepository = _unitOfMeasureRepository;
    recipeRepository = _recipeRepository;
  }

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent _contextRefreshedEvent)
  {
    log.debug("Saving all recipes. please wait");
    recipeRepository.saveAll(getRecipes());
  }

  private List<Recipe> getRecipes()
  {
    List<Recipe> recipes = new ArrayList<>(2);

    //Get UOMs
    Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
    if (!eachUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
    if (!tablespoonUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    if (!teaspoonUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
    if (!dashUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
    if (!pintUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");
    if (!cupsUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
    if (!pinchUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
    if (!ounceUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }
    Optional<UnitOfMeasure> smallUomOptional = unitOfMeasureRepository.findByDescription("Small");
    if (!smallUomOptional.isPresent())
    {
      throw new RuntimeException("Exception UOM not found!");
    }

    UnitOfMeasure each = eachUomOptional.get();
    UnitOfMeasure tablespoon = tablespoonUomOptional.get();
    UnitOfMeasure teaspoon = teaspoonUomOptional.get();
    UnitOfMeasure dash = dashUomOptional.get();
    UnitOfMeasure pint = pintUomOptional.get();
    UnitOfMeasure cup = cupsUomOptional.get();
    UnitOfMeasure pinch = pinchUomOptional.get();
    UnitOfMeasure ounce = ounceUomOptional.get();
    UnitOfMeasure small = smallUomOptional.get();

    // Get categories
    Optional<Category> americanOptional = categoryRepository.findByDescription("American");
    if (!americanOptional.isPresent())
    {
      throw new RuntimeException("Exception Category not found!");
    }
    Optional<Category> italianOptional = categoryRepository.findByDescription("Italian");
    if (!italianOptional.isPresent())
    {
      throw new RuntimeException("Exception Category not found!");
    }
    Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
    if (!mexicanOptional.isPresent())
    {
      throw new RuntimeException("Exception Category not found!");
    }
    Optional<Category> fastFoodOptional = categoryRepository.findByDescription("Fast Food");
    if (!fastFoodOptional.isPresent())
    {
      throw new RuntimeException("Exception Category not found!");
    }

    Category american = americanOptional.get();
    Category mexican = mexicanOptional.get();
    Category italian = italianOptional.get();
    Category fastFood = fastFoodOptional.get();

    //Yummy Guac
    Recipe guacRecipe = new Recipe();
    guacRecipe.setDescription("Perfect Guacemole");
    guacRecipe.setPrepTime(10);
    guacRecipe.setCookTime(0);
    guacRecipe.setDifficulty(Difficulty.EASY);
    guacRecipe.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat\n" +
            "2. Make the marinade and coat the chicken:\n" +
            "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
            "\n" +
            "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
            "\n" +
            "3. Grill the chicken:\n" +
            "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
            "\n" +
            "4. Warm the tortillas:\n" +
            "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
            "\n" +
            "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
            "\n" +
            "5. Assemble the tacos:\n" +
            "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
    Notes guacNote = new Notes();
    guacNote.setNote("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.");
    guacRecipe.setNote(guacNote);

    guacRecipe.addIngredients(new Ingredient("ripe avocados", new BigDecimal(2), each));
    guacRecipe.addIngredients(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon));
    guacRecipe.addIngredients(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), tablespoon));
    guacRecipe.addIngredients(new Ingredient("Minced red onion, or thinly sliced green onion", new BigDecimal(2), tablespoon));
    guacRecipe.addIngredients(new Ingredient("Serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each));
    guacRecipe.addIngredients(new Ingredient("Cilantro", new BigDecimal(2), tablespoon));
    guacRecipe.addIngredients(new Ingredient("Freshly grated black pepper", new BigDecimal(2), dash));
    guacRecipe.addIngredients(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each));

    guacRecipe.getCategories().add(american);
    guacRecipe.getCategories().add(mexican);

    recipes.add(guacRecipe);

    //Yummy tacos
    Recipe taco = new Recipe();
    taco.setDescription("Spicy Grilled Chicken Taco");
    taco.setCookTime(9);
    taco.setPrepTime(20);
    taco.setDifficulty(Difficulty.MODERATE);
    taco.setDirections("1. Prepare a gas or charcoal grill for medium-high, direct heat\n" +
            "2. Make the marinade and coat the chicken:\n" +
            "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
            "\n" +
            "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
            "\n" +
            "Spicy Grilled Chicken Tacos\n" +
            "3. Grill the chicken:\n" +
            "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
            "\n" +
            "4. Warm the tortillas:\n" +
            "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
            "\n" +
            "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
            "\n" +
            "5. Assemble the tacos:\n" +
            "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
  Notes tacoNote = new Notes();
  tacoNote.setNote("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
          "\n" +
          "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
          "\n" +
          "Today's tacos are more purposeful ? a deliberate meal instead of a secretive midnight snack!\n" +
          "\n" +
          "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
          "\n" +
          "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
          "\n" +
          "The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
          "\n" +
          "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well ? this green isn't traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
          "\n" +
          "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
          "\n" +
          "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that's living!");
  taco.setNote(tacoNote);
  taco.addIngredients(new Ingredient("Acho chili powder", new BigDecimal(2), tablespoon));
  taco.addIngredients(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon));
  taco.addIngredients(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon));
  taco.addIngredients(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
  taco.addIngredients(new Ingredient("Salt", new BigDecimal(".5"), teaspoon));
  taco.addIngredients(new Ingredient("Clove Garlic, finely chopped", new BigDecimal(1), each));
  taco.addIngredients(new Ingredient("Finely grated orange zest", new BigDecimal(1), tablespoon));
  taco.addIngredients(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon));
  taco.addIngredients(new Ingredient("olive oil", new BigDecimal(2), tablespoon));
  taco.addIngredients(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(4), each));
  taco.addIngredients(new Ingredient("small corn tortillas", new BigDecimal(8), each));
  taco.addIngredients(new Ingredient("packed baby arugula", new BigDecimal(3), cup));
  taco.addIngredients(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), each));
  taco.addIngredients(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each));
  taco.addIngredients(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pint));
  taco.addIngredients(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each));
  taco.addIngredients(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each));
  taco.addIngredients(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(".5"), cup));
  taco.addIngredients(new Ingredient("lime, cut into wedges", new BigDecimal(1), each));

  taco.getCategories().add(american);
  taco.getCategories().add(mexican);

  recipes.add(taco);
  return recipes;


  }
}

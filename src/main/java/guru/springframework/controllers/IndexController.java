package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController
{
  private final RecipeService recipeService;

  public IndexController(RecipeService _recipeService)
  {
    recipeService = _recipeService;
  }

  @RequestMapping({"", "/", "/index"})
  public String getIndex(Model _model)
  {
    log.debug("adding recipes to model");
    _model.addAttribute("recipes", recipeService.getRecipes());
    return "index";
  }
}

package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest
{
@Mock
RecipeRepository recipeRepository;
RecipeServiceImpl service;

  @Before
  public void setUp() throws Exception
  {
    MockitoAnnotations.initMocks(this);
    service = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  public void getRecipes()
  {
    //Setup
    Set<Recipe> recipesData = new HashSet<>();
    recipesData.add(new Recipe());
    when(recipeRepository.findAll()).thenReturn(recipesData);
    //Execute
    Set<Recipe> recipes = service.getRecipes();
    //Verify
    assertEquals(1, recipes.size());
    verify(recipeRepository, times(1)).findAll();
  }
}
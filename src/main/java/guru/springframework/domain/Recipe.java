package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private Integer prepTime;
  private Integer cookTime;
  private Integer servings;
  private String source;
  private String url;
  @Lob
  private String directions;
  @Lob
  private Byte[] image;
  @Enumerated(value = EnumType.STRING)
  private Difficulty difficulty;
  @ManyToMany
  @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
  private Set<Ingredient> ingredients = new HashSet<>();
  @OneToOne(cascade = CascadeType.ALL)
  private Notes note;

  public void setNote(Notes _note)
  {
    note = _note;
    _note.setRecipe(this);
  }

  public Recipe addIngredients(Ingredient _ingredient)
  {
    _ingredient.setRecipe(this);
    ingredients.add(_ingredient);
    return this;
  }
}

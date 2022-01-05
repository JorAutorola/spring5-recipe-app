package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String description;
   private BigDecimal amount;

   @OneToOne(fetch = FetchType.EAGER)
   private UnitOfMeasure uom;
   @ManyToOne
   private Recipe recipe;

  public Ingredient(String _description, BigDecimal _amount, UnitOfMeasure _uom)
  {
    description = _description;
    amount = _amount;
    uom = _uom;
  }

}

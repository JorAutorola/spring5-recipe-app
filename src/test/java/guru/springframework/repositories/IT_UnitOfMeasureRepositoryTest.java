package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class IT_UnitOfMeasureRepositoryTest
{
  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Test
  public void findByDescription()
  {
    String teaspoon = "Teaspoon";
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(teaspoon);

    assertEquals(teaspoon, uomOptional.get().getDescription());
  }
  @Test
  public void findByDescriptionCup()
  {
    String cup = "Cup";
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(cup);

    assertEquals(cup, uomOptional.get().getDescription());
  }
}
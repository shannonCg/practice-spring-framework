package app.baseCRUD.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import app.baseCRUD.model.entity.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer>{
    List<Hero> findByHeroNameContainingIgnoreCase(@Param("heroName")String heroName);
}

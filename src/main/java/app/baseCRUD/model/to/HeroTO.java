package app.baseCRUD.model.to;

import app.baseCRUD.model.entity.Hero;

public class HeroTO {
    
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HeroTO convertFrom(Hero hero){
        HeroTO to = new HeroTO();
        to.setId(hero.getHeroId());  
        to.setName(hero.getHeroName());
        return to;
    }
}

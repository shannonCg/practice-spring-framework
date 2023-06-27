package app.baseCRUD.model.vo;

import javax.validation.constraints.Size;

public class HeroVO {
    
    @Size(max=10)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package app.baseCRUD.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.baseCRUD.model.entity.Hero;
import app.baseCRUD.model.to.HeroTO;
import app.baseCRUD.model.vo.HeroVO;
import app.baseCRUD.repository.HeroRepository;
import app.error.exception.PathIdNotFoundException;

@Service
public class HeroService {
    
    @Autowired
    private HeroRepository dao;

    public HeroTO add(HeroVO vo){
        Hero entity = new Hero();
        return HeroTO.convertFrom(saveByVO(entity, vo));
    }

    public void update(Integer id, HeroVO vo){
        Hero entity = _getById(id);
        saveByVO(entity, vo);
    }

    private Hero saveByVO(Hero entity, HeroVO vo){
        entity.setHeroName(vo.getName());
        return dao.save(entity);
    }

    public void deleteById(Integer id){
        Hero entity = _getById(id);
        dao.delete(entity);
    }
    
    public HeroTO getById(Integer id){
        Hero entity = _getById(id);
        return HeroTO.convertFrom(entity);
    }
    
    private Hero _getById(Integer id){
        return dao.findById(id)
                    .orElseThrow(() -> new PathIdNotFoundException("id", String.valueOf(id)));
    }
    
    public List<HeroTO> getAlls(){
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                            .map(e -> HeroTO.convertFrom(e))
                            .collect(Collectors.toList());
    }

    public List<HeroTO> findByName(String name){
        return dao.findByHeroNameContainingIgnoreCase(name)
                .stream()
                .map(e -> HeroTO.convertFrom(e))
                .collect(Collectors.toList());
    }
}

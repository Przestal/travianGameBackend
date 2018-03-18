package com.sda.webgame.services;

import com.sda.webgame.model.*;
import com.sda.webgame.model.dto.CreateColonyDto;
import com.sda.webgame.model.factory.ColonyFactory;
import com.sda.webgame.model.factory.ColonyLotFactory;
import com.sda.webgame.repositories.ColonyRepository;
import com.sda.webgame.repositories.GameUserRepository;
import com.sda.webgame.repositories.GameWorldFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColonyService implements IColonyService {

    @Autowired
    private ColonyRepository colonyRepository;
    @Autowired
    private GameWorldFieldRepository gameWorldFieldRepository;
    @Autowired
    private GameUserRepository gameUserRepository;



    @Override
    public Optional<Colony> tryCreateColony(CreateColonyDto dto) {
        Optional<GameUser> userCreatingColony = gameUserRepository.getGameUserById(dto.getUserId());
        if (!userCreatingColony.isPresent()){
            return Optional.empty();

        }

        Optional<GameWorldField> fieldOnWhichColonyIsToBePlaced = gameWorldFieldRepository.getGameWorldFieldById(dto.getFieldId());
        if (!fieldOnWhichColonyIsToBePlaced.isPresent()){
            return Optional.empty();
        }
        //is grass in field
        GameWorldField field = fieldOnWhichColonyIsToBePlaced.get();
        if (field.getFieldType() != WorldFieldType.GRASS){
            return  Optional.empty();
        }
        //is exists colony in field
        if (colonyRepository.existsColonyByField(field)){
            return Optional.empty();
        }
        Colony createColony = ColonyFactory.create(
                userCreatingColony.get(),field,dto);
        createColony = colonyRepository.save(createColony);
        return Optional.ofNullable(createColony);

    }

    @Override
    public Optional<Colony> getColony(Long id) {
        Optional<Colony> colony =colonyRepository.getColonyById(id);
        return colony;
    }


}

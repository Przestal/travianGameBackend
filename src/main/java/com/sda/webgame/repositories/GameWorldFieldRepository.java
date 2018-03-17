package com.sda.webgame.repositories;


import com.sda.webgame.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface GameWorldFieldRepository extends CrudRepository<GameWorldField, Long> {

    Optional<GameWorldField> getGameWorldFieldById(long fieldId);
}

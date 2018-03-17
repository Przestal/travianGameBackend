package com.sda.webgame.repositories;


import com.sda.webgame.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GameWorldFieldRepository extends CrudRepository<GameWorldField, Long> {
}

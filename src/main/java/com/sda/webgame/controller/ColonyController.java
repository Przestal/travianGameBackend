package com.sda.webgame.controller;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.dto.CreateColonyDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.IColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/colony/")
public class ColonyController {

    @Autowired
    private IColonyService colonyService;

    @RequestMapping(path = "/create")
    public ResponseMessage<Colony> createColony(@RequestBody CreateColonyDto dto){
        Optional<Colony> createColony = colonyService.tryCreateColony(dto);
        if (createColony.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK,"Colony created", createColony.get());

        }else {
            return new ResponseMessage<>(StatusResponse.SERVER_ERROR, "Can't create colony. ", null);
        }

    }


}

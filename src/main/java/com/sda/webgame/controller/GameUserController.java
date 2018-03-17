package com.sda.webgame.controller;

import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.dto.GameUserDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.IGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user/")
public class GameUserController {

    @Autowired
    private IGameUserService gameUserService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
        public ResponseMessage<GameUser> registerUser(@RequestBody GameUserDto user){

        Optional<GameUser> registrationResult = gameUserService.tryRegister(user);

        if (registrationResult.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK,null,registrationResult.get());
        }
        throw new IllegalArgumentException();
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ResponseMessage<GameUser> loginUser(@RequestBody GameUserDto  userData){
        Optional<GameUser> registrationResult = gameUserService.tryLogin(userData);

        if (registrationResult.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK,"Logged in", registrationResult.get());
        }else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "Invalid user or password", null);
        }
    }
}

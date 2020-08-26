package com.cf.colorm.controller;

import com.cf.colorm.entity.Store;
import com.cf.colorm.service.StoreServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("colorm/store")
public class StoreController {

    @Autowired
    private StoreServer storeServerImpl;

    @GetMapping("/get")
    public Store getStore(int id){
        return storeServerImpl.findStoreByid(id);
    }

}

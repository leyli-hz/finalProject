package com.me.model.service;

import com.me.model.entity.Car;

import java.util.List;

public interface GenericService<Type> {

        void save(Type typeObject)throws Exception;
        void update(Type typeObject)throws Exception;
        void remove(int id)throws Exception;
        List<Type> findAll( )throws Exception;

}

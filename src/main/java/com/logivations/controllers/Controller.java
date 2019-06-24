package com.logivations.controllers;

import com.logivations.businessLogics.BusinessLogic;
import com.logivations.helpers.DataBase;
import com.logivations.models.Case;
import com.logivations.models.Order;
import java.util.List;

public class Controller {

   public List<Case> checkAndPutProductsInCase(List<Case> cases, List<Order> orders) {
        return new BusinessLogic().checkBySizeParameters(new BusinessLogic().checkByVolume(cases, orders));
    }

    public<T> void createObjectInDataBase(T object){
       DataBase.createObjectInDB(object);
    }
}

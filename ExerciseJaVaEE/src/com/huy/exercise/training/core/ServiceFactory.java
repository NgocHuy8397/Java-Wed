package com.huy.exercise.training.core;

import java.util.HashMap;
import java.util.Map;

import com.huy.exercise.training.service.ICustomerService;
import com.huy.exercise.training.service.impl.CustomerService;

public class ServiceFactory {
    private static Map<Class<?>,Object> map = new HashMap<>();
    static {
        init();
    }
    
    private static void init() {
        ServiceFactory.register(ICustomerService.class, new CustomerService());
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> clazz) {
        return (T) map.get(clazz);
    }
    
    public static <T> void register(Class<T> clazz, T t) {
        map.put(clazz, t);
    }
}

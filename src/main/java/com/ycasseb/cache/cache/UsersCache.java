package com.ycasseb.cache.cache;

import com.ycasseb.cache.model.Users;
import com.ycasseb.cache.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UsersCache {

    @Autowired
    UsersRepository usersRepository;

    @CacheEvict(value = "usersCache", key = "#name", allEntries = true, condition = "#refreshCache", beforeInvocation = true)
    @Cacheable(value = "usersCache", key = "#name")
    public Users getUser(String name, boolean refreshCache) {
        System.out.println("Retrieving from Database for name: " + name);
        return usersRepository.findByName(name);
    }
}

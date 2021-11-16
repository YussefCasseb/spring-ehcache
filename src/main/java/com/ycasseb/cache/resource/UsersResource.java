package com.ycasseb.cache.resource;

import com.ycasseb.cache.cache.UsersCache;
import com.ycasseb.cache.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    UsersCache usersCache;

    @GetMapping(value = "/{name}")
    public Users getUser(@PathVariable final String name, @RequestParam final boolean refreshCache) {
        return usersCache.getUser(name, refreshCache);
    }
}

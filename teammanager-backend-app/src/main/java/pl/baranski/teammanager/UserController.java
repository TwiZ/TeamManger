package pl.baranski.teammanager;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.baranski.teammanager.db.MongoFactory;
import pl.baranski.teammanager.so.User;

import java.net.UnknownHostException;

@Slf4j
@RestController
@ResponseBody
public class UserController {

    @Autowired
    private MongoFactory mongoFactory;

    @PostMapping(value = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody User user) {
        DBCollection users = mongoFactory.getDatabase().getCollection("users");

        users.insert(BasicDBObjectBuilder.start().add("first", user.getFirst()).add("last", user.getLast()).get());

    }

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getUsers() {
        DBCursor users = mongoFactory.getDatabase().getCollection("users").find();
        StringBuilder stringBuilder = new StringBuilder();
        users.forEach(dbObject -> {
            log.info(dbObject.toString());
            stringBuilder.append(dbObject);
        });
        return stringBuilder.toString();
    }

}
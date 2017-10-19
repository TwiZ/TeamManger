package pl.baranski.teammanager;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("TeamManager");
            DBCollection collection = database.getCollection("TheCollectionName");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        return "Greetings from Spring Boot!";
    }

}
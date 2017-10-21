package pl.baranski.teammanager.db;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Slf4j
@Service
public class MongoFactory {


    public void getUserCollection() {
        DB database = getDatabase();
        System.out.println("Collections:");
        database.getCollectionNames().forEach(log::info);
        DBCollection users = database.getCollection("users");
        DBObject dbObject = BasicDBObjectBuilder.start().add("name", "Bartosz").add("age", 32).get();
        users.insert(dbObject);


        users.insert(BasicDBObjectBuilder.start().add("name", "Bartosz").add("last", "Barański").add("age", 32).get());

        users.find().forEach(dbObject1 -> log.info(dbObject1.toString()));
    }

    public DB getDatabase() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            DB database = mongoClient.getDB("TeamManager");
            System.out.println("Databases:");
            mongoClient.getDatabaseNames().forEach(log::info);
            return database;
        } catch (UnknownHostException e) {
            throw new RuntimeException("Problem with connecting to database", e);
        }
    }
}

# java-kafka-demo

To connect to the db:

```
docker-compose up -d
docker exec -it postgres_java_kafka bash
psql -U minompi
```

List of db:
```
\l
```

To create db:
```
CREATE DATABASE customer;
```

To connect to a db:
```
\c customer
```

After being connected to the db you can write your own queries:
```
select * from customer;
```

Run the following commands in order to start all services in the correct order:

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties
Open another terminal session and run:

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

# Create a topic
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

# Write in a topic
$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
This is my first event
This is my second event

# Read a topic
$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

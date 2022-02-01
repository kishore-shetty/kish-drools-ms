# Getting Started

* 
### Update Kafka Configuration

* update dataDir in zookeeper.properties with C:/DevTools/kafka/zookeeper-data
* update log.dirs in zookeeper.properties with C:/DevTools/kafka/kafka-logs

### Kafka Commands
* .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
* .\bin\windows\kafka-server-start.bat .\config\server.properties
* .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic kishore.topic
* .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181


* ProfileApplication class has code to publish to kafka topic
* KafkaConsumer is listener class that consumes the messages from kafka topic.



 
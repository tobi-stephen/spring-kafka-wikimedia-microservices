### Microservices setup with Kafka

- The setup is a multi-module maven project with streaming wikimedia recent changes to a kafka broker
- A wiki-message consumer project to save the streams into a MySQL db
- A REST Api exposed to query the streams from the DB

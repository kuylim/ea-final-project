# Enterprise Architecture - Final Project
This project just a proof of concept to demonstrate how enterprise architectue worked.
We implement base on `Movie Rating` concept, for detail project spec refer to [this document](https://github.com/kuylim/ea-nov-2022-final-project).

## Core Tech Stack
### Microservices
* Discorvery service
* API Gateway
* Configuration service
* Tracing (Zipkin and Sleuth)
* Implement Eventual Consistency
### Message Queue
* Kafka
* RabbitMQ
### Security
* OAthu 2 (Integrate with Keycloak)
* Vault
### Database
* PostgreSQL
### Deployment
* Google Jib
* Docker-compose
* Docker

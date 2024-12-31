## Infrastructure

### Kafka (v7.8.0)

#### Docker-compose

##### start 
- `$ docker-compose -f common.yml -f kafka_cluster.yml up -f postgres.yml -d`

##### show
- `$ docker-compose -f common.yml -f kafka_cluster.yml -f postgres.yml ps`

##### stop
- `$ docker-compose -f common.yml -f kafka_cluster.yml -f postgres.yml down`
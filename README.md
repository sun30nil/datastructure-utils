# datastructure-utils

# Immutable Queue:

Usage:

Clone: 

```git clone https://github.com/sun30nil/datastructure-utils.git```

Change to the java project directory

```cd dscollection```

To ensure all the tests run successfully (100% Coverage), run below command

```mvn clean test```
### Brute-Force Implementation:
1. Uses java.utils LinkedList to preserve queue elements
2. Enqueue is O(N), since existing LinkedList is cloned with every enqueue operation
3. Dequeue is O(N), since existing LinkedList is cloned with every dequeue operation
4. Refer to this implementation ```com.sunil.ds.immutable.queue.ImmutableQueue```
5. Refer to the unit tests here ```com.sunil.ds.immutable.queue.ImmutableQueueTest```

### Efficient Implementation:
1. Uses Immutable LinkedList with addToLast and removeFromLast implementation using headLinkedList and tailLinkedList
2. Every enqueue is O(1) since item is added to the end of the ImmutableLinkedList
3. Dequeue is O(N) in worst case since ref to first inserted item to queue is held as head and when thats empty we need reverse the tail queue to head LinkedList
4. Implementation ref: ```com.sunil.ds.immutable.queue.FastImmutableQueue```
5. Unit tests:  ```com.sunil.ds.immutable.queue.FastImmutableQueueTest```


# Analytics Backend System Design

![alt text](https://github.com/sun30nil/datastructure-utils/blob/master/AnalyticsAppArchitecture.png)

I've tried to make the design as self explanatory as possible and below will answer the system design needs:

1) handle large write volume: Billions write events per day.

    * Each user's metric is sent to his specific availability zone, so the traffic is distributed there.
    * Microservice based design of API service enables distributing the load of api requests and can be scaled horizontally.
    * Each microserivce dumps metrics to specific topic in kafka.
    * Each consumer group aggregates data on their topics and saves to a Redis making first level of aggregation.
    * The aggregator then scheduled to aggregate data from redis to Cassandra.
    * Cassandra is very scalable with Availabilty and Partition Tolerance and consistency can be tuned via replication factor.
    * Further there's scheduled aggregator which run and aggregate hourly, daily data to S3 so that long period reporting becomes fast.
    * Data Retention period of these datastores can be set accordinly as per paid v/s unpaid customers.

2) handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics.

    * Redis + Cassandra is answer for realtime metrics 
    * Scheduled Aggregators + Cassandra for near realtime and time based report generation

3) provide metrics to customers with at most one hour delay.

    * Scheduled Aggregators + Cassandra + S3 will solve this.

4) run with minimum downtime.

    * Cassandra is highly available (masterless model)
    * Redis is single master so we have a backup redis instance (can be handled using Hystrix)
    * Kafka is highly available but if goes down, we can have rabbitmq as backup queuing system

5) have the ability to reprocess historical data in case of bugs in the processing logic.

    * We've a backup reprocessing Compute facility we can be run on need basis by a consumer group - setting the offset to the required time.
    
    
### Centralized Logging:
ELK (open source), Splunk (enterprise/paid), Cloudwatch

### Development:
Springboot - Java 11 
Containerization 
IntelliJ

### Alerting:
Granfana, PagerDuty, Cloudwatch

### Monitoring:
Grafana (InfluxDB), Opentracing

### CI/CD:
GIT, Jenkins

### Agile:
Jira

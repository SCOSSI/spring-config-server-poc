<h1>Spring cloud config server POC</h1>

**What is this POC for:**

This poc was implemented to understand how centralized configuration works with spring cloud config server. For 
this implementation we used four services in the docker-compose to test how it works.

**Config Server service:**

The config server service handles the communication with another github [repository](https://github.com/SCOSSI/server-cloud-config) that contains the configuration
files in yml. 

**RabbitMQ service:**
  
  The RabbitMq service is needed by the spring cloud bus dependency that is used in the client services to refresh the 
configuration without needing to restart the service.

**Client service one:**
  
  The client service one communicates with config server to get the configuration files based in a hlg environment
  and listen to a rabbitmq queue to know when he needs to update the configuration.
  
**Client service two:**
  
  The client service one communicates with config server to get the configuration files based in a dev environment
  and listen to a rabbitmq queue to know when he needs to update the configuration.   



**Prerequisites to run the POC:**<br/>
Docker<br/>
Docker compose

**How to run the POC:**<br/>
In you bash you just need to run "docker-compose up"

**Available api's to test the config server:**<br/>
Service one(hlg): curl -f http://localhost:8082/api<br/>
Service two(dev): curl -f http://localhost:8083/api

After changing any configuration in the config [repository](https://github.com/SCOSSI/server-cloud-config) you can 
call an api in service one or two that it will send to the queue and it will replicate to the other service.

Service one: http://localhost:8082/actuator/bus-refresh<br/>
Service two: http://localhost:8083/actuator/bus-refresh

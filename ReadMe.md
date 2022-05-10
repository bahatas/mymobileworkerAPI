
<p align="center">
<br>
</p>

# My Mobile Worker Spring Boot, MySQL, Rest API

This simple Api created for proper basic get and post responses.

## Scenario:
ACME deliveries wishes to create delivery jobs for its team of drivers/riders, to allow
these jobs to be managed / maintained and to allow the jobs to be accessed by those delivering.
Expected Calls:

● create_job(s) <br>
● Get_jobs<br>

##Assumptions:
Clients ask from company for delivery/shipping. Clients considered as starting point. Clients expectation is moving their 
stuff one location to another. This is defined as a job. Each job object need a driver/rider object to perform clients demand.
That is represented with DriverRider Object. Each Job has content to ship. This is considered as JobItem object.

##Scope:
Scope on Api is covering basic CRUD operations on relational database like MySql.

##Test:
Tests are executed manually with Postman tool. 

## Steps to Setup

**1. Clone the application**

```bash
git clone git@github.com:bahatas/mymobileworkerAPI.git
```

**2. Create Mysql database**
```bash
create database acme-testdb
```
- run `src/main/resources/data.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8000>
Swagger document will be avaliable at  <http://localhost:8000/swagger-ui.html>

## Explore Rest APIs

The app defines following CRUD APIs.


### Jobs

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/v1/jobs/list | Get all job list from database | |
| GET    | /api/v1/jobs/{jobId} | Get job by id  | |
| POST    | /api/v1/jobs/create | Create a new job object|[JSON](#job-create) |


### Clients

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/v1/clients/list  | Get Clients list| | |

Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="job-create">Job-create -> /api/v1/jobs/create</a>
```json
{
  "jobReference": "5h",
  "location": "Liverpool",
  "description": "Delivery",
  "deliveryDate": "2022-05-09",
  "deliveryTime": "12:12:12",
  "status": "NEW",
  "client_id": {
    "id": 1
  },
  "driverRider_id": {
    "id": 1
  },
  "jobItemList_id": [
    {
      "description": "Pc boxes"
    }
  ]
}
```



##### <a id="job-list">Job List -> /api/v1/jobs/create</a>
```json
{
  "success": true,
  "code": 200,
  "created_at": "2022-05-10T01:10:28.420+00:00",
  "request_id": "13a41402-4526-47fc-ae46-d6afa932196e",
  "data": [
    {
      "id": 1,
      "jobReference": "1A",
      "location": "Liverpool",
      "description": "Fragile Box Cargo",
      "deliveryDate": "2022-06-01",
      "deliveryTime": "14:00:00",
      "status": "NEW",
      "client_id": {
        "id": 1,
        "firstName": "Jon",
        "lastName": "Goodman",
        "phoneNumber": "123456789",
        "email": null
      },
      "driverRider_id": {
        "id": 1,
        "firstName": "Matt",
        "lastName": "Driver",
        "phoneNumber": "123456789"
      },
      "jobItemList_id": [
        {
          "id": 1,
          "createdAt": "2022-05-07T11:55:56",
          "updatedAt": "2022-06-01T12:00:00",
          "isDeleted": false,
          "description": "10 Monitor box"
        },
        {
          "id": 2,
          "createdAt": "2022-05-07T11:55:56",
          "updatedAt": "2022-06-01T12:00:00",
          "isDeleted": false,
          "description": "8 Laptop case "
        },
        {
          "id": 3,
          "createdAt": "2022-05-07T11:55:56",
          "updatedAt": "2022-06-01T12:00:00",
          "isDeleted": false,
          "description": "5 Desk"
        }
      ]
    }
  ]
}
```
![segment](https://api.segment.io/v1/pixel/track?data=ewogICJ3cml0ZUtleSI6ICJwcDJuOTU4VU1NT21NR090MWJXS0JQd0tFNkcydW51OCIsCiAgInVzZXJJZCI6ICIxMjNibG9nYXBpMTIzIiwKICAiZXZlbnQiOiAiQmxvZ0FwaSB2aXNpdGVkIiwKICAicHJvcGVydGllcyI6IHsKICAgICJzdWJqZWN0IjogIkJsb2dBcGkgdmlzaXRlZCIsCiAgICAiZW1haWwiOiAiY29tcy5zcHVyc0BnbWFpbC5jb20iCiAgfQp9)
# Tech Track

## YouTube video demonstration
https://youtu.be/-LuRfLWOM3c

The application for processing data of tech equipment

## General information
#### Language / Framework
- Java Oracle OpenJDK 17
- Spring Boot 3.2.2

#### DBMS
- PostgreSQL


## The application usage
API Specification Documentation: _/swagger-ui/index.html_

### Sign up
POST {{host}}/trusted/auth/sign-up
Content-Type: application/json
```json
{
"username": "aidarsvd",
"name": "Aidar Chakiev",
"password": "Chakiev#4"
}
```


### Sign in
POST {{host}}/trusted/auth/sign-in
Content-Type: application/json

{
"username": "jdoe",
"password": "c28d7a2e"
}

### Create user
POST {{host}}/admin/user-create
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

{
"username": "jdoe",
"name": "John Doe"
}

### Assign authority to user
POST {{host}}/admin/assign-authority
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

{
"username": "jdoe",
"authority": "equipment.delete"
}

### Get user list
GET {{host}}/admin/get-users
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

### Deactivaye user
POST {{host}}/admin/delete-user
Content-Type: application/x-www-form-urlencoded
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

username = jdoe


### Activate user
POST {{host}}/admin/activate-user
Content-Type: application/x-www-form-urlencoded
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

username = jdoe

### Equipment create
POST {{host}}/equipment/create
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE

{
"model": "GPS Modules"
}

### Equipment get
GET {{host}}/equipment/get-list?s=f
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaWRhcnN2ZCIsImV4cCI6MTcyMzk3ODE2MH0.GTlpaRfeaG6gV_NicGoWctxFc7Pu64-7k2mLJGDSsWE


### Data submit
POST {{host}}/data/submit
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZG9lIiwiZXhwIjoxNzI1Mzc5NjE5fQ.2ixDe-t2VXDCO-IIAdBzo2ICHi7sNs99XeinFl9IZrc

{
"rawValue": "100",
"unit": "HV",
"description": "from test",
"equipmentId": 1
}


### Create alert
POST {{host}}/alert/create
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZG9lIiwiZXhwIjoxNzI1Mzc5NjE5fQ.2ixDe-t2VXDCO-IIAdBzo2ICHi7sNs99XeinFl9IZrc

{
"alertMessage": "High risk!",
"priority": "EXTREME_HIGH",
"equipmentId": 1
}

### Get alerts
GET {{host}}/alert/get-all
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZG9lIiwiZXhwIjoxNzI1Mzc5NjE5fQ.2ixDe-t2VXDCO-IIAdBzo2ICHi7sNs99XeinFl9IZrc


### Delete alert
DELETE {{host}}/alert/delete/1
Content-Type: application/json
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZG9lIiwiZXhwIjoxNzI1Mzc5NjE5fQ.2ixDe-t2VXDCO-IIAdBzo2ICHi7sNs99XeinFl9IZrc
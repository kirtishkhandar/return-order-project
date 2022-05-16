How to run:
1. Import as maven project in IDE
3. update the git repo location in config server's properties file
2. Run all microservices in sequence... eureka, config, gateway ... remaining.

Exposed Endpoints:
1. Post request
http://localhost:8765/auth/signup
{
    "username":"user1",
    "email":"user1@mail.com",
    "role":["ROLE_MODERATOR"],
    "password":"user123"
}

2. Post requst
http://localhost:8765/auth/signin
{
    "username":"user1",
    "password":"user123"
}

3.Get request with token
http://localhost:8765/ProcessDetail
{
    "name": " abc ",
    "contactNumber": "123",
    "componentType": "Integral",
    "componentName": "xyz",
    "quantity": "1"
}

4. Post request with token
http://localhost:8765/CompleteProcessing
{
    "requestId": "b2e24f7573794ae788225ef2226c07f9",
    "creditCardNumber": "123",
    "creditlimit": "333",
    "processingCharge": "500"
}

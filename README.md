# Ktor-Debug

Service used for debugging ktor.

## Routes

### Successful Routes

#### Successful response at application layer

`GET /v1/success/application`

#### Successful response at domain layer

`GET /v1/success/domain`

#### Successful response at persistence layer

`GET /v1/success/persistence`

### Failure Routes

#### Failed response at application layer

`GET /v1/failure/application`

#### Failed response at domain layer

`GET /v1/failure/domain`

#### Failed response at persistence layer

`GET /v1/failure/persistence`
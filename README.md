# Person-Location fetcher

A RESTful API for a person & location retrieval application using Java and Spring Data REST, consuming Ziptastic API.

## Problem Statement
See Code-Challenge-Instructions-mid.txt

## Endpoint(s)
http://localhost:8181/persons

## Demo

### Post Request
{"firstName":"Allen",

"lastName":"Zabe",

"email":"allenzabe@domain.com",

"zipcode":"48864",

"garbageData":"xyz"}

### Get Response
{"id":1,

"firstName":"Allen",

"lastName":"Zabe",

"email":"allenzabe@domain.com",

"zipcode":48864,

"city":"Okemos"}

## Technologies
Spring Data

Hibernate

JPA

H2

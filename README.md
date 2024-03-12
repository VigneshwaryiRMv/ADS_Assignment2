POST : http://localhost:8080/area

{
    "name": "Forest Reserve",
    "habitats": ["Tropical Forest", "Wetland"]
}


GET: http://localhost:8080/areas

POST: http://localhost:8080/species
{
    "species": {
        "name": "Tiger",
        "population": 15500
    },
    "habitatName": "Tropical Forest"
}

GET : http://localhost:8080/decision
{
    "species": {
        "name": "Tiger",
        "population":15500
    },
    "habitatName": "Tropical Forest"
}

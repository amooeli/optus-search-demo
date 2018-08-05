# search-words-demo

1 - Build the project: 
mvn clean install

2 - Run the project: 
mvn spring-boot:run

Sample Request for search:
curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Content-Type: application/json" -d '{"searchText": ["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -X POST

Sample Request for top counts:
curl http://localhost:8080/counter-api/top/5 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
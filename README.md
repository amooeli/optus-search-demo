# optus-search-demo

1 - Build the project: mvn clean install

2 - Run the project: mvn spring-boot:run

Task 1: Search the following texts, which will return the counts respectively.

curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Content-Type: application/json" -d '{"searchText": ["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -X POST

Task 2: Provide the top 20 (as Path Variable) Texts, which has the highest counts in the Sample Paragraphs provided.

curl http://localhost:8080/counter-api/top/5 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
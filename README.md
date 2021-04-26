# About

This application takes in a URL of text file containing customer data, and short lists customers based on their
proximity to Intercom Office

## Requirements

1. [java 8+](https://java.com/en/download/help/download_options.html)
2. [maven](https://maven.apache.org/install.html)

## Installation

1. Clone the project
2. cd into intercom-take-home-test
3. mvn clean install

## Run

mvn spring-boot:run

or

java -jar demo-0.0.1-SNAPSHOT.jar

## Usage

After running the app,try the following endpoints in a browser. Output is also written into a file

src/main/resources/static/output.txt

## End points

http://localhost:8080/customers
This endpoint reads the input file and returns the content, which is customer data.

http://localhost:8080/customers/shortlist/{distance}
This endpoint takes in a parameter, distance in kilometers, and returns records of customers within the given distance
of Intercom Ofiice.

## Examples:

http://localhost:8080/customers/invitees/150 (returns records of customers within 150Kms of Intercom Office)

http://localhost:8080/customers/invitees/ (default distance value is 100kms. Returns records of customers within 100Kms
of Intercom Office )
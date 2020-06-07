# JsonSQL4J
[![Build Status](https://github.com/eaxdev/JsonSQL4J/workflows/build/badge.svg)](https://github.com/eaxdev/JsonSQL4J/actions)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/eaxdev/Java-JsonResume-Validator/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.eaxdev/jsonsql4j.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.eaxdev%22%20AND%20a:%22jsonsql4j%22)
[![codecov](https://codecov.io/gh/eaxdev/JsonSQL4J/branch/master/graph/badge.svg)](https://codecov.io/gh/eaxdev/JsonSQL4J)

This library for mapping JSON style query objects to SQL queries

# Get it!

## Maven

You can use following Maven dependency:

```xml
<dependency>
  <groupId>io.github.eaxdev</groupId>
  <artifactId>jsonsql4j</artifactId>
  <version>0.0.1</version>
</dependency>
```
## Gradle

```groovy
implementation 'io.github.eaxdev:jsonsql4j:0.0.1'
```
Also, you can use [GitHub Packages](https://github.com/eaxdev/JsonSQL4J/packages).

# Use it!

Given JSON:

```json
{
  "fields": [
    {"column": "field1"},
    {"column": "field2", "alias": "test"}
  ],
  "from": [
    {"table": "table1", "schema": "schema"}
  ],
  "where": {
    "or": [
      { "eq": {"fieldName": "field3", "value": "5"} },
      { "eq": {"fieldName": "field4", "value": "3"} }
    ]
  }
}
```

use library:

```java
SelectQuery selectQuery = new SelectQuery(jsonString);
String query = selectQuery.getSelect();
// query = SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 OR field4 = 3)

```
You can find more examples [here](src/test/resources).

## License

JsonSQL4J is open-source project, and distributed under the [MIT](http://choosealicense.com/licenses/mit/) license

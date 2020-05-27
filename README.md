# JsonSQL4J
[![Build Status](https://github.com/eaxdev/JsonSQL4J/workflows/build/badge.svg)](https://github.com/eaxdev/JsonSQL4J/actions)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/eaxdev/Java-JsonResume-Validator/master/LICENSE)

This library for mapping JSON style query objects to SQL queries

## How to start?

Publish in MavenCentral in progress....

## Usage

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
```

`selectQuery` give this query:

```sql
SELECT field1, field2 AS test FROM schema.table1 WHERE (field3 = 5 OR field4 = 3)
```

## License

JsonSQL4J is open-source project, and distributed under the [MIT](http://choosealicense.com/licenses/mit/) license

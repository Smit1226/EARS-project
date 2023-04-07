## Development

Replace the username and password with yours

### schema migration

```
mysql --user="root" --password="12345678" ears < schema.sql
```

### database seeding

```
mysql --user="root" --password="12345678" ears < seed.sql
```

### db reset

in case you want to clean up data for development

```
mysql --user="root" --password="12345678" ears < reset.sql
```

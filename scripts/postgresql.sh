#!/bin/bash
echo "Starting postgresql database with:"
echo "    user=quark"
echo "    pass=quark"
echo "  dbname=quark_db"
echo "    port=5432"
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
           --name postgres-quarkus \
           -e POSTGRES_USER=quark \
           -e POSTGRES_PASSWORD=quark \
           -e POSTGRES_DB=quark_db \
           -p 5432:5432 postgres:10.5

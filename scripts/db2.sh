#!/bin/bash
echo "Starting DB2 database with:"
echo "    user=quark"
echo "    pass=quark"
echo "  dbname=quark_db"
echo "    port=50000"
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \
  --name db2-quarkus \
  -e DBNAME=quark_db \
  -e DB2INSTANCE=quark \
  -e DB2INST1_PASSWORD=quark \
  -e AUTOCONFIG=false \
  -e ARCHIVE_LOGS=false \
  -e LICENSE=accept \
  -p 50000:50000 \
  --privileged \
  ibmcom/db2:11.5.0.0a


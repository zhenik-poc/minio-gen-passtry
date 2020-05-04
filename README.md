# Minio data generator [scheduler]
Cron-job application, put `.json` file into minio `bucket`. 
This project uses Quarkus, the [Supersonic Subatomic Java Framework](https://quarkus.io/)
Application build with GraalVM. 

## How to run locally
```
make run
```

## Prerequisites
* Minio bucket should exist
 
## Configuration via env variables
| ENV        | Default value           | Description  |
| :------------- |:-------------|:-----|
| BYSYKKEL_CLIENT_IDENTIFIER      | zhenik-test | According to [BySykkel documentation](https://oslobysykkel.no/apne-data/sanntid), client should put information about itself in header 'Client-Identifier' |
| BYSYKKEL_API_URL      | https://gbfs.urbansharing.com/oslobysykkel.no/station_status.json       |   Bysykkel API url to [station statuses](https://github.com/NABSA/gbfs/blob/master/gbfs.md#station_statusjson) |
| CRON_EXPR | 0 */1 * * * ?      |    How often trigger data transfer. [Cron job syntax description](https://www.freeformatter.com/cron-expression-generator-quartz.html)  |
| MINIO_URL | http://localhost:9000      |  Minio url    |
| MINIO_ACCESS_KEY | minio      |  Minio access key    |
| MINIO_SECRET_KEY | minio123      |  Minio secret key    |
| MINIO_BUCKETNAME | default      |  Minio bucket name, which to put objects    |
| MINIO_BUCKETNAME_SUFFIX | bike/      |  Minio bucket suffix. E.g. object will have path default/bike/12312340.json where is `default` is bucket name and `bike` is bucket suffix   |


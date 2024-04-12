# Create Table
aws --endpoint="http://localhost:4566" dynamodb create-table \
  --region "sa-east-1" \
  --table-name "payment" \
  --attribute-definitions \
    "AttributeName=number_id,AttributeType=S" \
    "AttributeName=value,AttributeType=S" \
  --key-schema \
    "AttributeName=number_id,KeyType=HASH" \
    "AttributeName=value,KeyType=RANGE" \
  --provisioned-throughput \
      "ReadCapacityUnits=5,WriteCapacityUnits=5"
**Endpoints**

curl --location 'localhost:8080/invoices/1'

curl --location 'localhost:8080/invoices'

curl --location 'localhost:8080/invoices' \
--header 'Content-Type: application/json' \
--data '{
"customerName": "NextGen Enterprises",
"date": "2025-08-20",
"lines": [
{
"product": "Printer",
"quantity": 2,
"unitPrice": 150.0
},
{
"product": "Ink Cartridge",
"quantity": 10,
"unitPrice": 20.0
}
]
}'

curl --location --request PUT 'localhost:8080/invoices/2' \
--header 'Content-Type: application/json' \
--data '{
"id": 4,
"customerName": "Osito",
"date": "2025-08-24",
"lines": [
{
"product": "Gloves",
"quantity": 1,
"unitPrice": 15.0
},
{
"product": "Shoes",
"quantity": 1,
"unitPrice": 150.0
},
{
"product": "Ink Cartridge",
"quantity": 10,
"unitPrice": 20.0
}
]
}'

curl --location --request DELETE 'localhost:8080/invoices/1'

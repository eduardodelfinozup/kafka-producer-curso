## kafka Producer
# pedidos
```shell
cd ./docker
docker-compose up
```

```shell
cd ./docker
docker-compose down
```
# kafdrop
```
http://http://localhost:19000/
```


# Payload Pedidos
```
curl --request POST \
  --url http://localhost:8080/pedidos \
  --header 'Content-Type: application/json' \
  --data '{
	"idCliente": 445,
        "idRestaurante": 78985,
        "items": [
         {
            "quantidade": 2,
            "sku": 125778,
            "valor": 10.25
         }
      ]
    }'
```
# Payload conta
```
curl --request POST \
  --url http://localhost:8080/contas \
  --header 'Content-Type: application/json' \
  --data '{
	"documentoTitular":35385638807,
	"nomeTitular":"Rafaela da Costa",
	"agencia":1000,
	"numero":123,
	"saldo":250
}'
```
# Promocao

```
curl --request POST \
  --url http://localhost:8080/promocoes \
  --header 'Content-Type: application/json' \
  --data '

{
    "idProduto":1,
    "inicio": "25-02-2023",
    "fim": "25-06-2023",
    "valor": 50.55,   
    "regras": "PROMOÇÃO"
}
```

# Produto:
```
curl --request POST \
  --url http://localhost:8080/produtos \
  --header 'Content-Type: application/json' \
  --data '
	{
	    "titulo": "04-05-2023",
	    "descricao": "04-06-2023",
	    "preco": 50.55
	    
	}

```

# DELETAR PEDIDO

```
curl --request DELETE \
  --url localhost:8081/pedidos/2\  

```

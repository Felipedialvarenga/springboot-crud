<h1 align="center">
  Products CRUD
</h1>

API para gerenciar produtos (CRUD)

## Tecnologias
 
- [Spring Boot]
- [Spring Web MVC]
- [Spring Data JPA]
- [Spring Validation]
- [PostgreSQL]

## Práticas adotadas

- SOLID, YAGNI
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências

## API Endpoints

- Salvar Produto
```
$ http POST :8080/products name="Wireless Keyboad" price=670.00

{
	"idProduct": "b688a348-1637-480a-9ae2-8305e3677afb",
	"name": "Wireless Keyboad",
	"price": 670.00
}
```

- Listar Todos os Produtos
```
$ http GET :8080/products

[
  {
		"idProduct": "b688a348-1637-480a-9ae2-8305e3677afb",
		"name": "Wireless Keyboad",
		"price": 670.00
  }
]
```

- Listar um Único Produto
```
$ http GET :8080/products/b688a348-1637-480a-9ae2-8305e3677afb

{
	"idProduct": "b688a348-1637-480a-9ae2-8305e3677afb",
	"name": "Wireless Keyboad",
	"price": 670.00
}
```

- Atualizar Produto
```
$ http PUT :8080/products/b688a348-1637-480a-9ae2-8305e3677afb name="Wireless Keyboad" price=590.00

{
	"idProduct": "b688a348-1637-480a-9ae2-8305e3677afb",
	"name": "Wireless Keyboad",
	"price": 590.00
}
```

- Remover Produto
```
http DELETE :8080/products/b688a348-1637-480a-9ae2-8305e3677afb

"Product deleted successfully."
```
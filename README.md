[# Spoiled Girls Club

API do projeto Spoiled Girls Club - Loja Virtual de Moda

## Requisitos

- \[ \] CRUD - Carrinho
- \[ \] CRUD - Administração de Peças
- \[ \] CRUD - Controle de Pedidos
- \[ \] CRUD - Usuários
- \[ \] Autenticação

## Endpoints

<!--ROUPAS E CARRINHO/><!-->

- \[Listar Roupas\](#listar-roupas)
- \[Cadastrar Roupa\](#cadastrar-roupa)
- \[Apagar Roupa\](#apagar-roupa)
- \[Atualizar Roupa\](#atualizar-roupa)
- \[Adicionar Roupa\](#adicionar-roupa)

 <!--PEDIDO/><!-->

- \[Listar Pedidos\](#listar-pedidos)
- \[Cadastrar Pedido\](#cadastrar-pedido)
- \[Apagar Pedido\](#apagar-pedido)
- \[Atualizar Pedido\](#atualizar-pedido)

 <!--USUÁRIO/><!-->

- \[Cadastrar Usuários\](#cadastrar-usuarios)
- \[Apagar Usuário\](#apagar-usuario)
- \[Atualizar Usuário\](#atualizar-usuario)
- \[Conectar Usuário\](#conectar-usuario)

### Listar Roupas

`GET`/roupa
Retorna um array com as roupas disponíveis na loja

#### Exemplo de Resposta

```js
\[
    {
        "id": 1
        "nome": "Jaqueta de Lã",
        "foto": jaqueta-de-la,
        "preco": 219,00,
        "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
        "tamanho": "PP", "P", "M", "G", "GG",
        "quantidadeestoque": 250,
    }
 \]
```

#### Códigos de Status

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| \[200\]  | Lista de categorias retornada com sucesso |
| \[401\]  | Não autenticado. Se autentique em /login  |

### Cadastrar Roupa

`POST`/roupa
Cadastre uma roupa com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Roupa cadastrada com sucesso                      |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Roupa

`DELETE` /roupa/{id}
Apaga a roupa com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Roupa apagada com sucesso                      |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe roupa com o `id` informado          |

#### Atualizar Roupa

`PUT` /roupa/'{id}'
Atualiza a roupa de `id` informado no path, utilizando as informações do corpo requisição

### Listar Pedido

`GET`/pedido
Retorna um array com as informações do pedido do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
		"numero pedido" : 487374;
		"qtd": 2,
		"id item": 1;
		"preço" : 219,99,
		"tamanho": "M",
       "frete": {
           "descrição" : "Frete Expresso",
           "valor": "calculado dinamicamente por uma função interna"
       },
	}
\]
```

#### Códigos de Status

| Código | Descrição                                |
| ------ | ---------------------------------------- |
| \[200\]  | Lista de pedidos retornada com sucesso   |
| \[401\]  | Não autenticado. Se autentique em /login |

### Cadastrar Pedido

`POST`/pedidos
Cadastre um pedido com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Pedido cadastrado com sucesso                     |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Pedido

`DELETE` /pedido/{id}
Apaga o pedido com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Pedido apagado com sucesso                     |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe pedido com o `id` informado         |

#### Atualizar Pedido

`PUT` /pedido/'{id}'
Atualiza os dados do pedido `id` informado no path, utilizando as informações do corpo requisição

### Conectar Usuário

`GET`/login
Retorna um array com as informações de login do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
        "id_cadastro" : 1,
		"nome": "Sofia";
		"sobrenome": "Silva"
		"e-mail": "sofiasilva@gmail.com";
		"Senha": "Kp$7Jn#WuX@3"
		"Status": "Ativo"
	}
\]
```

### Cadastrar Usuário

`POST`/usuario
Cadastre um usuário com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo       | Tipo   | Obrigatório |
| ----------- | ------ | ----------- |
| ID          | INT    | ✅          |
| NOME        | STRING | ✅          |
| SOBRENOME   | STRING | ✅          |
| CPF         | STRING | ✅          |
| EMAIL       | STRING | ✅          |
| TELEFONE    | STRING | ✅          |
| ENDEREÇO    | STRING | ✅          |
| NUMEROCASA  | INT    | ✅          |
| BAIRRO      | STRING | ✅          |
| CIDADE      | STRING | ✅          |
| ESTADO      | STRING | ✅          |
| CEP         | STRING | ✅          |
| COMPLEMENTO | STRING | ❌          |
| SENHA       | STRING | ✅          |
| STATUS      | STRING | ✅          |

#### Exemplo de Requisição

```js
\[
    {
        "nome" : "nome_usuario";
    }
\]
```

#### Exemplo de Resposta

```js
\[
    {
        "id": 1;
        "nome" :  "Sofia";
        "sobrenome":  "Silva",
        "CPF": "123-456-789-01",
        "e-mail": "sofiasilva.corsi@gmail.com";
        "Telefone": "+55 (11) 97352-8350"
        "endereço" : "Avenida dos Sonhos",
        "numero" : 456;
        "Bairro": "Jardim Primavera",
        "Cidade" : "Rio de Janeiro",
        "Estado": "RJ";
        "CEP" : 20000-000;
        "Complemento": "",
        "Senha" : "Kp$7Jn#WuX@3"
        "Status": "Ativo"
    }
\]
```

### Apagar Usuário

`DELETE` /usuario/{id}
Apaga o usuario com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Usuário apagado com sucesso                    |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe usuário com o `id` informado        |

#### Atualizar Usuário

`PUT` /usuario/'{id}'
Atualiza os dados do usuário `id` informado no path, utilizando as informações do corpo requisição
](<d:/Projeto de Java/SpoiledGirlsClub-main/src/main/java/br/com/fiap/spoiledgirlsclub/validation>) [# Spoiled Girls Club

API do projeto Spoiled Girls Club - Loja Virtual de Moda

## Requisitos

- \[ \] CRUD - Carrinho
- \[ \] CRUD - Administração de Peças
- \[ \] CRUD - Controle de Pedidos
- \[ \] CRUD - Usuários
- \[ \] Autenticação

## Endpoints

<!--ROUPAS E CARRINHO/><!-->

- \[Listar Roupas\](#listar-roupas)
- \[Cadastrar Roupa\](#cadastrar-roupa)
- \[Apagar Roupa\](#apagar-roupa)
- \[Atualizar Roupa\](#atualizar-roupa)
- \[Adicionar Roupa\](#adicionar-roupa)

 <!--PEDIDO/><!-->

- \[Listar Pedidos\](#listar-pedidos)
- \[Cadastrar Pedido\](#cadastrar-pedido)
- \[Apagar Pedido\](#apagar-pedido)
- \[Atualizar Pedido\](#atualizar-pedido)

 <!--USUÁRIO/><!-->

- \[Cadastrar Usuários\](#cadastrar-usuarios)
- \[Apagar Usuário\](#apagar-usuario)
- \[Atualizar Usuário\](#atualizar-usuario)
- \[Conectar Usuário\](#conectar-usuario)

### Listar Roupas

`GET`/roupa
Retorna um array com as roupas disponíveis na loja

#### Exemplo de Resposta

```js
\[
    {
        "id": 1
        "nome": "Jaqueta de Lã",
        "foto": jaqueta-de-la,
        "preco": 219,00,
        "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
        "tamanho": "PP", "P", "M", "G", "GG",
        "quantidadeestoque": 250,
    }
 \]
```

#### Códigos de Status

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| \[200\]  | Lista de categorias retornada com sucesso |
| \[401\]  | Não autenticado. Se autentique em /login  |

### Cadastrar Roupa

`POST`/roupa
Cadastre uma roupa com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Roupa cadastrada com sucesso                      |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Roupa

`DELETE` /roupa/{id}
Apaga a roupa com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Roupa apagada com sucesso                      |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe roupa com o `id` informado          |

#### Atualizar Roupa

`PUT` /roupa/'{id}'
Atualiza a roupa de `id` informado no path, utilizando as informações do corpo requisição

### Listar Pedido

`GET`/pedido
Retorna um array com as informações do pedido do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
		"numero pedido" : 487374;
		"qtd": 2,
		"id item": 1;
		"preço" : 219,99,
		"tamanho": "M",
       "frete": {
           "descrição" : "Frete Expresso",
           "valor": "calculado dinamicamente por uma função interna"
       },
	}
\]
```

#### Códigos de Status

| Código | Descrição                                |
| ------ | ---------------------------------------- |
| \[200\]  | Lista de pedidos retornada com sucesso   |
| \[401\]  | Não autenticado. Se autentique em /login |

### Cadastrar Pedido

`POST`/pedidos
Cadastre um pedido com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Pedido cadastrado com sucesso                     |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Pedido

`DELETE` /pedido/{id}
Apaga o pedido com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Pedido apagado com sucesso                     |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe pedido com o `id` informado         |

#### Atualizar Pedido

`PUT` /pedido/'{id}'
Atualiza os dados do pedido `id` informado no path, utilizando as informações do corpo requisição

### Conectar Usuário

`GET`/login
Retorna um array com as informações de login do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
        "id_cadastro" : 1,
		"nome": "Sofia";
		"sobrenome": "Silva"
		"e-mail": "sofiasilva@gmail.com";
		"Senha": "Kp$7Jn#WuX@3"
		"Status": "Ativo"
	}
\]
```

### Cadastrar Usuário

`POST`/usuario
Cadastre um usuário com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo       | Tipo   | Obrigatório |
| ----------- | ------ | ----------- |
| ID          | INT    | ✅          |
| NOME        | STRING | ✅          |
| SOBRENOME   | STRING | ✅          |
| CPF         | STRING | ✅          |
| EMAIL       | STRING | ✅          |
| TELEFONE    | STRING | ✅          |
| ENDEREÇO    | STRING | ✅          |
| NUMEROCASA  | INT    | ✅          |
| BAIRRO      | STRING | ✅          |
| CIDADE      | STRING | ✅          |
| ESTADO      | STRING | ✅          |
| CEP         | STRING | ✅          |
| COMPLEMENTO | STRING | ❌          |
| SENHA       | STRING | ✅          |
| STATUS      | STRING | ✅          |

#### Exemplo de Requisição

```js
\[
    {
        "nome" : "nome_usuario";
    }
\]
```

#### Exemplo de Resposta

```js
\[
    {
        "id": 1;
        "nome" :  "Sofia";
        "sobrenome":  "Silva",
        "CPF": "123-456-789-01",
        "e-mail": "sofiasilva.corsi@gmail.com";
        "Telefone": "+55 (11) 97352-8350"
        "endereço" : "Avenida dos Sonhos",
        "numero" : 456;
        "Bairro": "Jardim Primavera",
        "Cidade" : "Rio de Janeiro",
        "Estado": "RJ";
        "CEP" : 20000-000;
        "Complemento": "",
        "Senha" : "Kp$7Jn#WuX@3"
        "Status": "Ativo"
    }
\]
```

### Apagar Usuário

`DELETE` /usuario/{id}
Apaga o usuario com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Usuário apagado com sucesso                    |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe usuário com o `id` informado        |

#### Atualizar Usuário

`PUT` /usuario/'{id}'
Atualiza os dados do usuário `id` informado no path, utilizando as informações do corpo requisição
](<d:/Projeto de Java/SpoiledGirlsClub-main/src/main/java/br/com/fiap/spoiledgirlsclub/validation/Tamanho.java>) [# Spoiled Girls Club

API do projeto Spoiled Girls Club - Loja Virtual de Moda

## Requisitos

- \[ \] CRUD - Carrinho
- \[ \] CRUD - Administração de Peças
- \[ \] CRUD - Controle de Pedidos
- \[ \] CRUD - Usuários
- \[ \] Autenticação

## Endpoints

<!--ROUPAS E CARRINHO/><!-->

- \[Listar Roupas\](#listar-roupas)
- \[Cadastrar Roupa\](#cadastrar-roupa)
- \[Apagar Roupa\](#apagar-roupa)
- \[Atualizar Roupa\](#atualizar-roupa)
- \[Adicionar Roupa\](#adicionar-roupa)

 <!--PEDIDO/><!-->

- \[Listar Pedidos\](#listar-pedidos)
- \[Cadastrar Pedido\](#cadastrar-pedido)
- \[Apagar Pedido\](#apagar-pedido)
- \[Atualizar Pedido\](#atualizar-pedido)

 <!--USUÁRIO/><!-->

- \[Cadastrar Usuários\](#cadastrar-usuarios)
- \[Apagar Usuário\](#apagar-usuario)
- \[Atualizar Usuário\](#atualizar-usuario)
- \[Conectar Usuário\](#conectar-usuario)

### Listar Roupas

`GET`/roupa
Retorna um array com as roupas disponíveis na loja

#### Exemplo de Resposta

```js
\[
    {
        "id": 1
        "nome": "Jaqueta de Lã",
        "foto": jaqueta-de-la,
        "preco": 219,00,
        "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
        "tamanho": "PP", "P", "M", "G", "GG",
        "quantidadeestoque": 250,
    }
 \]
```

#### Códigos de Status

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| \[200\]  | Lista de categorias retornada com sucesso |
| \[401\]  | Não autenticado. Se autentique em /login  |

### Cadastrar Roupa

`POST`/roupa
Cadastre uma roupa com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Roupa cadastrada com sucesso                      |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Roupa

`DELETE` /roupa/{id}
Apaga a roupa com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Roupa apagada com sucesso                      |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe roupa com o `id` informado          |

#### Atualizar Roupa

`PUT` /roupa/'{id}'
Atualiza a roupa de `id` informado no path, utilizando as informações do corpo requisição

### Listar Pedido

`GET`/pedido
Retorna um array com as informações do pedido do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
		"numero pedido" : 487374;
		"qtd": 2,
		"id item": 1;
		"preço" : 219,99,
		"tamanho": "M",
       "frete": {
           "descrição" : "Frete Expresso",
           "valor": "calculado dinamicamente por uma função interna"
       },
	}
\]
```

#### Códigos de Status

| Código | Descrição                                |
| ------ | ---------------------------------------- |
| \[200\]  | Lista de pedidos retornada com sucesso   |
| \[401\]  | Não autenticado. Se autentique em /login |

### Cadastrar Pedido

`POST`/pedidos
Cadastre um pedido com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Pedido cadastrado com sucesso                     |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Pedido

`DELETE` /pedido/{id}
Apaga o pedido com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Pedido apagado com sucesso                     |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe pedido com o `id` informado         |

#### Atualizar Pedido

`PUT` /pedido/'{id}'
Atualiza os dados do pedido `id` informado no path, utilizando as informações do corpo requisição

### Conectar Usuário

`GET`/login
Retorna um array com as informações de login do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
        "id_cadastro" : 1,
		"nome": "Sofia";
		"sobrenome": "Silva"
		"e-mail": "sofiasilva@gmail.com";
		"Senha": "Kp$7Jn#WuX@3"
		"Status": "Ativo"
	}
\]
```

### Cadastrar Usuário

`POST`/usuario
Cadastre um usuário com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo       | Tipo   | Obrigatório |
| ----------- | ------ | ----------- |
| ID          | INT    | ✅          |
| NOME        | STRING | ✅          |
| SOBRENOME   | STRING | ✅          |
| CPF         | STRING | ✅          |
| EMAIL       | STRING | ✅          |
| TELEFONE    | STRING | ✅          |
| ENDEREÇO    | STRING | ✅          |
| NUMEROCASA  | INT    | ✅          |
| BAIRRO      | STRING | ✅          |
| CIDADE      | STRING | ✅          |
| ESTADO      | STRING | ✅          |
| CEP         | STRING | ✅          |
| COMPLEMENTO | STRING | ❌          |
| SENHA       | STRING | ✅          |
| STATUS      | STRING | ✅          |

#### Exemplo de Requisição

```js
\[
    {
        "nome" : "nome_usuario";
    }
\]
```

#### Exemplo de Resposta

```js
\[
    {
        "id": 1;
        "nome" :  "Sofia";
        "sobrenome":  "Silva",
        "CPF": "123-456-789-01",
        "e-mail": "sofiasilva.corsi@gmail.com";
        "Telefone": "+55 (11) 97352-8350"
        "endereço" : "Avenida dos Sonhos",
        "numero" : 456;
        "Bairro": "Jardim Primavera",
        "Cidade" : "Rio de Janeiro",
        "Estado": "RJ";
        "CEP" : 20000-000;
        "Complemento": "",
        "Senha" : "Kp$7Jn#WuX@3"
        "Status": "Ativo"
    }
\]
```

### Apagar Usuário

`DELETE` /usuario/{id}
Apaga o usuario com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Usuário apagado com sucesso                    |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe usuário com o `id` informado        |

#### Atualizar Usuário

`PUT` /usuario/'{id}'
Atualiza os dados do usuário `id` informado no path, utilizando as informações do corpo requisição
](<d:/Projeto de Java/SpoiledGirlsClub-main/src/main/java/br/com/fiap/spoiledgirlsclub/validation/TamanhoValidator.java>) [# Spoiled Girls Club

API do projeto Spoiled Girls Club - Loja Virtual de Moda

## Requisitos

- \[ \] CRUD - Carrinho
- \[ \] CRUD - Administração de Peças
- \[ \] CRUD - Controle de Pedidos
- \[ \] CRUD - Usuários
- \[ \] Autenticação

## Endpoints

<!--ROUPAS E CARRINHO/><!-->

- \[Listar Roupas\](#listar-roupas)
- \[Cadastrar Roupa\](#cadastrar-roupa)
- \[Apagar Roupa\](#apagar-roupa)
- \[Atualizar Roupa\](#atualizar-roupa)
- \[Adicionar Roupa\](#adicionar-roupa)

 <!--PEDIDO/><!-->

- \[Listar Pedidos\](#listar-pedidos)
- \[Cadastrar Pedido\](#cadastrar-pedido)
- \[Apagar Pedido\](#apagar-pedido)
- \[Atualizar Pedido\](#atualizar-pedido)

 <!--USUÁRIO/><!-->

- \[Cadastrar Usuários\](#cadastrar-usuarios)
- \[Apagar Usuário\](#apagar-usuario)
- \[Atualizar Usuário\](#atualizar-usuario)
- \[Conectar Usuário\](#conectar-usuario)

### Listar Roupas

`GET`/roupa
Retorna um array com as roupas disponíveis na loja

#### Exemplo de Resposta

```js
\[
    {
        "id": 1
        "nome": "Jaqueta de Lã",
        "foto": jaqueta-de-la,
        "preco": 219,00,
        "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
        "tamanho": "PP", "P", "M", "G", "GG",
        "quantidadeestoque": 250,
    }
 \]
```

#### Códigos de Status

| Código | Descrição                                 |
| ------ | ----------------------------------------- |
| \[200\]  | Lista de categorias retornada com sucesso |
| \[401\]  | Não autenticado. Se autentique em /login  |

### Cadastrar Roupa

`POST`/roupa
Cadastre uma roupa com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Roupa cadastrada com sucesso                      |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Roupa

`DELETE` /roupa/{id}
Apaga a roupa com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Roupa apagada com sucesso                      |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe roupa com o `id` informado          |

#### Atualizar Roupa

`PUT` /roupa/'{id}'
Atualiza a roupa de `id` informado no path, utilizando as informações do corpo requisição

### Listar Pedido

`GET`/pedido
Retorna um array com as informações do pedido do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
		"numero pedido" : 487374;
		"qtd": 2,
		"id item": 1;
		"preço" : 219,99,
		"tamanho": "M",
       "frete": {
           "descrição" : "Frete Expresso",
           "valor": "calculado dinamicamente por uma função interna"
       },
	}
\]
```

#### Códigos de Status

| Código | Descrição                                |
| ------ | ---------------------------------------- |
| \[200\]  | Lista de pedidos retornada com sucesso   |
| \[401\]  | Não autenticado. Se autentique em /login |

### Cadastrar Pedido

`POST`/pedidos
Cadastre um pedido com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo             | Tipo   | Obrigatório |
| ----------------- | ------ | ----------- |
| ID                | INT    | ✅          |
| NOME              | STRING | ✅          |
| FOTO              | STRING | ✅          |
| PRECO             | DOUBLE | ✅          |
| DESCRIÇÃO         | STRING | ✅          |
| TAMANHO           | STRING | ✅          |
| QUANTIDADEESTOQUE | INT    | ✅          |

#### Exemplo de Requisição

```js
\[
  {
    nome: "Jaqueta de Lã",
  },
\];
```

#### Exemplo de Resposta

```js
\[
	{
		"id": 1
       "nome": "Jaqueta de Lã",
       "foto": jaqueta-de-la,
       "preco": 219,00,
       "descricao": "Feita com tecido de alta qualidade, essa jaqueta de lã proporciona conforto e estilo para os dias frios. Com design moderno e detalhes elegantes, é perfeita para enfrentar as baixas temperaturas com estilo e sofisticação."
       "tamanho": "PP", "P", "M", "G", "GG",
       "quantidadeestoque": 250,
	}
\]
```

#### Código de Status

| Código | Descrição                                         |
| ------ | ------------------------------------------------- |
| \[201\]  | Pedido cadastrado com sucesso                     |
| \[400\]  | Validação falhou. Verifique o corpo da requisição |
| \[401\]  | Não autenticado. Se autentique em /login_admin    |

### Apagar Pedido

`DELETE` /pedido/{id}
Apaga o pedido com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Pedido apagado com sucesso                     |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe pedido com o `id` informado         |

#### Atualizar Pedido

`PUT` /pedido/'{id}'
Atualiza os dados do pedido `id` informado no path, utilizando as informações do corpo requisição

### Conectar Usuário

`GET`/login
Retorna um array com as informações de login do usuário

#### Exemplo de Resposta

```js
\[
	{
		"id": 1;
        "id_cadastro" : 1,
		"nome": "Sofia";
		"sobrenome": "Silva"
		"e-mail": "sofiasilva@gmail.com";
		"Senha": "Kp$7Jn#WuX@3"
		"Status": "Ativo"
	}
\]
```

### Cadastrar Usuário

`POST`/usuario
Cadastre um usuário com dados enviados no corpo de requisição

#### Corpo da Requisição

| Campo       | Tipo   | Obrigatório |
| ----------- | ------ | ----------- |
| ID          | INT    | ✅          |
| NOME        | STRING | ✅          |
| SOBRENOME   | STRING | ✅          |
| CPF         | STRING | ✅          |
| EMAIL       | STRING | ✅          |
| TELEFONE    | STRING | ✅          |
| ENDEREÇO    | STRING | ✅          |
| NUMEROCASA  | INT    | ✅          |
| BAIRRO      | STRING | ✅          |
| CIDADE      | STRING | ✅          |
| ESTADO      | STRING | ✅          |
| CEP         | STRING | ✅          |
| COMPLEMENTO | STRING | ❌          |
| SENHA       | STRING | ✅          |
| STATUS      | STRING | ✅          |

#### Exemplo de Requisição

```js
\[
    {
        "nome" : "nome_usuario";
    }
\]
```

#### Exemplo de Resposta

```js
\[
    {
        "id": 1;
        "nome" :  "Sofia";
        "sobrenome":  "Silva",
        "CPF": "123-456-789-01",
        "e-mail": "sofiasilva.corsi@gmail.com";
        "Telefone": "+55 (11) 97352-8350"
        "endereço" : "Avenida dos Sonhos",
        "numero" : 456;
        "Bairro": "Jardim Primavera",
        "Cidade" : "Rio de Janeiro",
        "Estado": "RJ";
        "CEP" : 20000-000;
        "Complemento": "",
        "Senha" : "Kp$7Jn#WuX@3"
        "Status": "Ativo"
    }
\]
```

### Apagar Usuário

`DELETE` /usuario/{id}
Apaga o usuario com o id informado no path

#### Código de Status

| Código | Descrição                                      |
| ------ | ---------------------------------------------- |
| \[204\]  | Usuário apagado com sucesso                    |
| \[401\]  | Não autenticado. Se autentique em /login_admin |
| \[404\]  | Não existe usuário com o `id` informado        |

#### Atualizar Usuário

`PUT` /usuario/'{id}'
Atualiza os dados do usuário `id` informado no path, utilizando as informações do corpo requisição
](<d:/Projeto de Java/SpoiledGirlsClub-main/src/main/java/br/com/fiap/spoiledgirlsclub/validation/ValidationErrorHandler.java>)
package br.com.fiap.spoiledgirlsclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarrinhoController {

    @RequestMapping(
        method = RequestMethod.GET, 
        path = "/carrinho", 
        produces = "application/json"
    )
    @ResponseBody
    public String index(){
        return """
            [
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
            ]
                """;
    }

}

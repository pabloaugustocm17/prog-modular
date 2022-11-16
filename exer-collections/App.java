import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    
    public static void main(String[] args) {
        

        List<Pedido> lista_pedidos = new ArrayList<>();
        
        
        for(int i = 0; i < 5 ; i++){
            lista_pedidos.add(AppAleat.criarPedido(i));
        }


        System.out.println("Quantidade de pedidos " + 
        "que contém mais de 4 comidas: " + contarPedidosMaiorQue4(lista_pedidos));

        //imprimiRelatorio(lista_pedidos);
        imrpimiMaisCara(lista_pedidos);

        System.out.println(quantidadePizzaSemNenhumAdicional(lista_pedidos));

    }

    private static long contarPedidosMaiorQue4(List<Pedido> lista){

        return lista.stream()
                    .filter(p -> p.quantidadeComidas() > 4)
                    .count();

    }

    private static void imprimiRelatorio(List<Pedido> lista){

        lista.stream()
                .filter(p -> p.valorTotal() > 150)
                .forEach(p -> imprimiPedido(p));
                
    }

    private static void imrpimiMaisCara(List<Pedido> lista){

        Pedido maior_pedido = lista.stream()
                                    .max(Comparator.comparing(Pedido::valorTotal))
                                    .orElseThrow();
                
        imprimiPedido(maior_pedido);
    }

    private static long quantidadePizzaSemNenhumAdicional(List<Pedido> lista){

        
        long valor = lista.stream()
            .filter(p -> p.toString().contains("Pizza  - R$25.0" + 
            "\nValor a pagar: R$25.0"))
            .count();
            


        return valor;

    }

    private static void imprimiPedido(Pedido pedido){
        System.out.println(pedido.relatorio());
    }

}

import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;

public class Streams {


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


        LongStream x = lista.stream()
            .mapToLong(p -> 
                p.getComidas()
                .stream()
                    .map(c -> c.descricao.equals("Pizza") && c.precoAdicionais() == 0)
                    .count());

            
        return x.sum();

    }

    private static void imprimiPedido(Pedido pedido){
        System.out.println(pedido.relatorio());
    }

}

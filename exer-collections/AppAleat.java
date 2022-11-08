/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


/**
 * App com diversas demonstrações de streams (sem um sistema 'de verdade')
 */
public class AppAleat {
    static Random aleat = new Random(42);
    
    
    /**
     * Cria uma refeição aleatoriamente (pizza ou sanduíche) com ingredientes aleatórios
     * @return Comida com ingredientes
     */
    public static Comida criarRefeicao(){
        Ingrediente[] ingr= {new Ingrediente("Bacon", 2, 3.95),
                             new Ingrediente("Palmito", 1, 4.95),
                             new Ingrediente("Calabresa", 2, 2.95)};

        Comida nova = null;
        int tipo = aleat.nextInt(3);
        int quantos = aleat.nextInt(3);
        
        switch(tipo){
            case 0: nova = new Pizza();
            break;
            case 1: nova = new Pizza(true);
            break;
            case 2: nova= new Sanduiche();            
        }
        for (int i = 0; i < quantos; i++) {
            int pos = aleat.nextInt(3);
            nova.addIngrediente(ingr[pos]);
        }
        return nova;
    }
    
    /**
     * Cria um pedido com 'quantasComidas' aleatórias nos itens
     * @param quantasComidas Quantidade de itens do pedido
     * @return Pedido com diversas comidas aleatórias
     */
    public static Pedido criarPedido(int quantasComidas){
        Comida nova = criarRefeicao();
        Data qualquerData = new Data(aleat.nextInt(28)+1, aleat.nextInt(12)+1);
        Pedido novo = new Pedido(qualquerData, nova);
        for (int i = 1; i < quantasComidas; i++) {
            novo.addItem(criarRefeicao());
        }        
        return novo;
    }

    /**
     * Utilizade para 'limpar' o console (terminal VT-100)
     */
    public static void limparTela(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        LinkedList<Pedido> todosOsPedidos = new LinkedList<>();
        
        int totalPedidos = 500;

        for (int i = 0; i < totalPedidos; i++) {
            todosOsPedidos.add(criarPedido(aleat.nextInt(10)+1));
        }

        for (Pedido pedido : todosOsPedidos) {
            System.out.println(pedido);
        }
         System.out.println("FIM");
         teclado.close();
    }
}

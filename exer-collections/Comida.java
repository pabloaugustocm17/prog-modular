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

/**
  * Classe Comida: POO básica
  * Usando: encapsulamento, construtores, static
  */
public abstract class Comida implements Comparable<Comida> {
    
    //#region atributos
    protected String descricao;
    protected double precoBase=0d;  
    protected PM_ArrayList<Ingrediente> ingredientes;
    private int totalAdicionais;

    //#endregion 

    /**
     * Cria uma comida 
     * @param descricao Descricao básica da comida.
     */
    public Comida(String descricao){
        this.descricao = descricao;
        this.ingredientes = new PM_ArrayList<Ingrediente>(10);
        this.totalAdicionais=0;
    }

    /**
     * Calcula o preço final: base + adicionais * preço dos adicionais
     * @return Preço final (double)
     */
    public double calcularPreco(){       
        return (this.precoBase + this.precoAdicionais());
    }

    protected double precoAdicionais(){
        double aux=0d;
       for (int i = 0; i < this.totalAdicionais; i++) {
                aux+= this.ingredientes.objectAt(i).precoFinal();   
        }
        return aux;
    }
   
    /**
     * Tenta adicionar ingredientes à comida. Só será executado se o total não exceder o limite
     * @param quantos Quantidade de ingredientes a adicionar.
     */
    public void addIngrediente(Ingrediente qual){
        this.ingredientes.addAtEnd(qual);
    }

     /**
     * Tenta remover um ingrediente da comida. O primeiro encontrado deste tipo será removido. Se não houver o ingrediente, ignora a operação. 
     * @param qual O ingrediente a ser removido. 
     */
    public void removeIngrediente(Ingrediente qual){
        this.ingredientes.removeObject(qual);
    }
   

    /**
     * Informa a quantidade de adicionais da comida
     * @return Inteiro com a quantidade de adicionais.
     */
    public int totalIngredientes(){
        return this.ingredientes.size();
    }
    /**
     * Retorna a descrição da comida. Formato:
     * <descricao> com <qtdAdicionais> adicionais - R$ <precoFinal> 
     * @return String no formato indicado.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("-----\n");
        sb.append(this.descricao+"  - R$"+ this.precoBase+"\n");
       
       for (Ingrediente ingrediente : ingredientes) {
            if(ingrediente!=null)
            sb.append(ingrediente+"\n");
       }
       
        sb.append("Valor a pagar: R$"+this.calcularPreco()+"\n");
        sb.append("-----");
        return sb.toString();
    }
  
    
    @Override
    public int compareTo(Comida o) {
        if(this.calcularPreco() > o.calcularPreco()) return 1;
        else if(this.calcularPreco() < o.calcularPreco()) return -1;
        return 0;
    }
   
}

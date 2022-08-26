import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VeiculoTest {

    public VeiculoTest(){
        
    }

    @Test
    public void CriarVeiculo(){
        
        Main.ImprimiMensagem("Cria Carro");

        Veiculo veiculo = new Veiculo("123456", "123456", 12, 13, 120);

        assertEquals(veiculo, Veiculo.CriaVeiculo());
        

    }

}

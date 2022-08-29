import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VeiculoTest {

    private Veiculo veiculo;

    public VeiculoTest(){
        this.veiculo = new Veiculo("123-7894", 500 , 120);
    }

    @Test
    public void RegistraDataAquisicao(){
        
        String data_aquisicao = this.veiculo.RegistraDataAquisicao();

        assertEquals("12/03/2000", data_aquisicao);

    }

    @Test
    public void RegistraConsumoLitro(){

        double consumo_litro = this.veiculo.RegistraConsumoLitro();

        assertEquals("20", Double.toString(consumo_litro));

    }

    @Test
    public void SaberKmTotalVeiculo(){

        assertEquals("500", this.veiculo.getKmtotal());

    }




}

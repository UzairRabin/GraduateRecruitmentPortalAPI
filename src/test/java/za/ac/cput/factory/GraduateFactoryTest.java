package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.model.Graduate;
import za.ac.cput.model.Qualification;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 */

class GraduateFactoryTest {

    @Test
    public void createGraduateTest() {
        Graduate graduate = GraduateFactory.createGraduateFactory("B1254","Chuma", "Edward",
                "Nxazonke", "219181187@mycput.ac.za", "chumaedward1569@gmail.com",
                "Mchumane19954@",
                "0847622511" + experience + qualification + cv);

        assertNotNull(graduate);
        System.out.println(graduate);


    }


}
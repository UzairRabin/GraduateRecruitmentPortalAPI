//package za.ac.cput.repository;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.factory.GraduateFactory;
//import za.ac.cput.model.Graduate;
//
//import java.util.List;
//
///**
// * @author Chuma Nxazonke
// * Student number: 219181187
// */
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class IGraduateRepositoryTest {
//    private IGraduateRepository repository;
//    private Graduate graduate;
//
//    @BeforeEach
//    void setUp(){
//
//        Graduate graduate = GraduateFactory.createGraduateFactory("B1254","Chuma", "Edward",
//                "Nxazonke", "219181187@mycput.ac.za", "chumaedward1569@gmail.com",
//                "Mchumane19954@",
//                "0847622511" + experience + qualification + cv);
//
//
//
//        assertNotNull(graduate);
//        System.out.println(graduate);
//    }
//
//    @Test
//    @Order(1)
//    void save(){
//        Graduate save = this.repository.save(this.graduate);
//        assertEquals(this.graduate,save);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Graduate read = this.repository.getById(this.graduate.getGraduateId());
//    }
//
//    @Test
//    @Order(3)
//    void update(){
//        Graduate update = this.repository.getById(this.graduate.getGraduateId());
//    }
//
//    @Test
//    @Order(4)
//    void findAll() {
//        List<Graduate> graduateList = this.repository.findAll();
//        assertSame(1, graduateList.size());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        this.repository.deleteById(this.graduate.getGraduateId());
//        List<Graduate> graduateList = this.repository.findAll();
//        assertSame(0, graduateList.size());
//    }
//}
//

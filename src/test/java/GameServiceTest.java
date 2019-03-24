import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import study.basecamp.config.AppConfig;
import study.basecamp.repository.NumberRepository;
import study.basecamp.service.GameService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GameServiceTest {

    @Autowired
    private GameService service;

    @Autowired
    private NumberRepository numberRepository;



    @Test
    public void When_MakeNumber_Expected_Make(){
        service.makeNumber(20);
        Assert.assertEquals(numberRepository.findById(1).get().getNumber() ,20);
    }

    @Test
    public void When_NumberEqulasGuess_Expected_GameWonAsTrue(){
        service.makeNumber(15);
        Assert.assertTrue(service.equlasNumbers(15 ,1));
    }

    @Test
    public void When_NumberEqualsGuess_Expected_GameWonAsFalse() {
        service.makeNumber(15);
        Assert.assertFalse(service.equlasNumbers(14 , 1));
    }
}

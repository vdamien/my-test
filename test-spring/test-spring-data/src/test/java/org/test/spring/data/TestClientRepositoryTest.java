package org.test.spring.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.test.spring.data.entity.Client;
import org.test.spring.data.entity.TypeClient;
import org.test.spring.data.repository.ClientRepository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Classe de test du org.test.spring.data.repository.
 * @author Netapsys
 * @version $Revision$ $Date$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager="transactionManagerTest",defaultRollback=true)
public class TestClientRepositoryTest
{
    @Autowired
    ClientRepository clientRepo;

    final static Logger logger = Logger.getLogger("TestClientRepositoryTest.class");

	@Test
    public void tstFindClientByNom(){
//		final Client client1=new Client();

        for (int i = 0; i<1;i++) {
            Client client1=new Client();
            client1.setNom("TOTO"+i);
            client1.setPrenom("titi"+i);
            client1.setTypeClient(TypeClient.PARTICULIER);
            clientRepo.save(client1);
        }

        List<Client> client = clientRepo.findByName("TOTO");



       /* Client client2=new Client();
        client2.setNom("TOTO2");
        client2.setPrenom("titi");
        client2.setTypeClient(TypeClient.PRO);
        client2 = clientRepo.save(client2);

        List<Client> founds=clientRepo.findByNomLike("TOT%");
        Assert.assertTrue(founds.size()>0);
        logger.info("[findByNomLike] On a trouve : " + founds);

        client2.setTypeClient(TypeClient.PARTICULIER);
        Client client = clientRepo.save(client2);

		*//*Assert.assertTrue(client.getId() > 0);
		//List<Customer> founds=customerRepo.findAll();
		List<Client> founds=clientRepo.findByNomLike("TOT%");
		Assert.assertTrue(founds.size()>0);
		logger.info("[findByNomLike] On a trouve : " + founds);

        founds=clientRepo.findByNomLikeAndPrenom("TOT%", "titi");
        Assert.assertTrue(founds.size()>0);
        logger.info("[findByNomLikeAndPrenom] On a trouve : " + founds);

        Long countClient = clientRepo.count();
        logger.info("[count] Nombre de client : " + countClient);*//*

		Client found=clientRepo.findOne(client.getId());
        clientRepo.findByNom("TOTO2");
		
		Assert.assertNotNull(found);*/
	}
	
	
}

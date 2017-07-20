package pl.com.britenet.kta.entity.donation;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;

public class Donator {

    @Id
    private String id;

    private MemberOfAssociation memberOfAssociation;
    private Client client;
    private String name;

    // TODO: 2017-07-19 jak rozwiązać taki problem, że donator to albo member albo klient, a nie wszystko w jednym?

}

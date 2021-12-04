package edu.dalhousie.business.Tender;

import edu.dalhousie.business.Tender.controller.Tender.ITender;
import edu.dalhousie.business.Tender.controller.Tender.Tender;
import edu.dalhousie.business.Tender.model.Auctioneer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class TenderTest {
    static ITender tender = null;
    static Collection<Auctioneer> Auctioneers = null;

    @BeforeAll
    public static void setUp(){
        tender =new Tender();
        Auctioneers = new ArrayList<>();
    }

    @Test
    public void auctionTest() throws Exception {
        tender.setTenderEvent("Canteen");

        Auctioneers.add(new Auctioneer("Tim Horton's", 50, 80, 3));
        Auctioneers.add(new Auctioneer("Adda", 60, 82, 2));
        Auctioneers.add(new Auctioneer("Passage to India", 55, 85, 5));

        tender.addNewAuctioneers(Auctioneers);

        Auctioneer winner = tender.startTender();

        Assertions.assertEquals(85, winner.getBid());
        Assertions.assertEquals("Passage to India", winner.getName());
    }
}
package edu.dalhousie.business.Events.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertWinnerNameQueryBuilderTest {
    @Test
    public void insertWinnerName(){
        InsertWinnerNameQueryBuilder insertWinnerNameQueryBuilder
                = new InsertWinnerNameQueryBuilder();
        String expectedQuery = insertWinnerNameQueryBuilder.insertWinnerName("Flash");
        String actualQuery = "INSERT INTO winner (winner_name) VALUES ('Flash')";
        assertEquals(expectedQuery,actualQuery);
    }
}

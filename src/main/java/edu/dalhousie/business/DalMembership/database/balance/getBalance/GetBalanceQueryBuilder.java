/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.DalMembership.database.balance.getBalance;
import static edu.dalhousie.business.DalMembership.database.MembershipDetailsConstant.*;

public class GetBalanceQueryBuilder implements IGetBalanceDAOQueryBuilder {
    private static GetBalanceQueryBuilder instance;
    private GetBalanceQueryBuilder(){

    }
    public static GetBalanceQueryBuilder getInstance(){
        if(instance==null){
            instance = new GetBalanceQueryBuilder();
        }
        return instance;
    }

    public String rechargeBalance(int id, double amount){
        return "update membership_details \n" +
                "set balance = balance + " + amount +" \n"+
                "where member_id = "+ id;
    }

    @Override
    public String selectBalanceQuery(int id) {
        return "SELECT "+
                BALANCE +
                " FROM "  +
                MEMBERSHIP_TABLE+
                " WHERE "+
                MEMBER_ID +" = " + id;
    }
}
package edu.dalhousie.business.DalMembership.controller.subscription;

import edu.dalhousie.business.DalMembership.model.Services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class BronzeSubscription extends Subscription implements ISubscription{

    public final static double MONTHLY_CHARGES = 0;
    private final String SUBSCRIPTION_NAME = "BRONZE";
    private List<Services> services = Arrays.asList(
            new Services("sports",0),
            new Services("swimming",0));
    private Set<Services> basicServices = new HashSet<>(services);
    private double discount;
    private double duration;
    private double subscriptionAmount;
    private double amountAfterDiscount;

    public BronzeSubscription(){
        super.subscriptionName = SUBSCRIPTION_NAME;
        super.note = note;
    }
    @Override
    public double calculateCharges() {
        return basicServices.stream().mapToDouble(x-> x.getCharges()).sum();
    }

    @Override
    public Double getMonthlyCharges() {
        return MONTHLY_CHARGES;
    }

    @Override
    public void initializeSubscription() {
        super.addServices(services);
    }

    @Override
    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    BiPredicate<Double, Double> isEligibleToSubscribe = (x, y) -> x > y ? true : false;

    @Override
    public BiPredicate<Double, Double> isEligibleToSubscribe() throws Exception {
        return (durationInMonths,balance)->{
            this.duration = durationInMonths;
            this.discount = calculateDiscount(MONTHLY_CHARGES,duration);
            this.subscriptionAmount = 0;
            this.amountAfterDiscount = applyDiscount(this.subscriptionAmount,this.discount);
            setTotalAmount(this.amountAfterDiscount);
            if (isEligibleToSubscribe.test(amountAfterDiscount, balance)) {
                return false;
            }
            return true;
        };
    }
}
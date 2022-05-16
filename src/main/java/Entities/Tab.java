package Entities;

import java.util.List;

public class Tab {

    public General general;
    public Payment payment;
    public CashWithdrawal cashWithdrawal;
    public Fee fee;
    public AdditionalInfoAndBonus additionalInfoAndBonus;
    public Insurance insurance;
    public Travel travel;


    public Tab(General general, Payment payment, CashWithdrawal cashWithdrawal, Fee fee, AdditionalInfoAndBonus additionalInfoAndBonus, Insurance insurance, Travel travel) {
        this.general = general;
        this.payment = payment;
        this.cashWithdrawal = cashWithdrawal;
        this.fee = fee;
        this.additionalInfoAndBonus = additionalInfoAndBonus;
        this.insurance = insurance;
        this.travel = travel;

    }

    public General getGeneral() {
        return general;
    }

    public Payment getPayment() {
        return payment;
    }

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public Fee getFee() {
        return fee;
    }

    public AdditionalInfoAndBonus getAdditionalInfoAndBonus() {
        return additionalInfoAndBonus;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public Travel getTravel() {
        return travel;
    }
}

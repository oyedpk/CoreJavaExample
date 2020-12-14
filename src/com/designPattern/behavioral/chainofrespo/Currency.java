package com.designPattern.behavioral.chainofrespo;

public class Currency {
    private int amount;

    public Currency(int amt) {
        amount=amt;
    }

    public int getAmount() {return amount;}

}
//The important point to note here is implementation of dispense method. you will notice that every implemenation
//is trying to process the request and based on the amount, it might process some or full part of it.
class Dollars50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.chain=dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=50) {
            int num = currency.getAmount()/50;
            int remainder = currency.getAmount()%50;
            System.out.println("Dispensing "+ num + "50$ note");
            if(remainder !=0)
                this.chain.dispense(new Currency(remainder));
        } else{
            this.chain.dispense(currency);
        }
    }
}

class Dollars20Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.chain=dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=20) {
            int num = currency.getAmount()/20;
            int remainder = currency.getAmount()%20;
            System.out.println("Dispensing "+ num + "20$ note");
            if(remainder !=0)
                this.chain.dispense(new Currency(remainder));
        } else{
            this.chain.dispense(currency);
        }
    }
}

class Dollars10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.chain=dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=10) {
            int num = currency.getAmount()/10;
            int remainder = currency.getAmount()%10;
            System.out.println("Dispensing "+ num + "10$ note");
            if(remainder !=0)
                this.chain.dispense(new Currency(remainder));
        } else{
            this.chain.dispense(currency);
        }
    }
}

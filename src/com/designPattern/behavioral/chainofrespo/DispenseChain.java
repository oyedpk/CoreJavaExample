package com.designPattern.behavioral.chainofrespo;

public interface DispenseChain {
    //base interface should have a method to define the next processor in the chain and the method that will
    //process the request
    void setNextChain(DispenseChain dispenseChain);
    void dispense(Currency currency);
}

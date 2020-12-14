package com.designPattern.behavioral.chainofrespo;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.util.Scanner;
//client doesn't know which part of the chain will processing the request and it send the request to the first
//object in the chain. Each object in the chain will have it's own implementation to process the request, either
//full or partial or to send it to the next object in the chain
public class AtmDispenserChain {
    private DispenseChain dispenseChain;

    public AtmDispenserChain() {
        this.dispenseChain=new Dollars50Dispenser();
        DispenseChain dispenseChain1 = new Dollars20Dispenser();
        DispenseChain dispenseChain2 = new Dollars10Dispenser();
        //set the chain of responsibility
        dispenseChain.setNextChain(dispenseChain1);
        dispenseChain1.setNextChain(dispenseChain2);
    }

    public static void main(String[] args) {
        AtmDispenserChain atmDispenserChain = new AtmDispenserChain();
        while(true) {
            int amount =0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount= input.nextInt();
            if(amount%10 !=0) {
                System.out.println("Amount should be in multiple of 10s!");
                return;
            }
            //process the request
            atmDispenserChain.dispenseChain.dispense(new Currency(amount));
        }
    }

}

package com.company;

import java.util.Iterator;

public class Interpreter {

    public static void main(String[] args) {
        Iterator token = Tokens.allTokens.iterator();
        while (token.hasNext()){
            System.out.println(token.next());
        }
        System.out.println(Tokens.allTokens.size());
    }
}

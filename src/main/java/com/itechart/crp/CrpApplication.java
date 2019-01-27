package com.itechart.crp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

@SpringBootApplication
public class CrpApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrpApplication.class, args);

        Queue<Integer> stack = Collections.asLifoQueue(new ArrayDeque<>());
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack);
        stack.poll();
        System.out.println(stack);
        stack.add(5);
        System.out.println(stack);

    }

}


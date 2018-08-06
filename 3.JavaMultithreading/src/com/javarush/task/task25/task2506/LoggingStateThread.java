package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        String currentState="";
        while (target.getState()!=State.TERMINATED) {
            if (currentState!=target.getState().toString()) {
                currentState=target.getState().toString();
                System.out.println(currentState);
            }
        }
        if (target.getState()==State.TERMINATED) {
            System.out.println(target.getState());
        }
    }
}

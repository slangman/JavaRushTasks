package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return e.getClass().getSimpleName() + " : " + e.getMessage() + " : " + t.getName();
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return e.getMessage() + " : " + e.getClass().getSimpleName() + " : " + t.getName();
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return t.getName() + " : " + e.getClass().getSimpleName() + " : " + e.getMessage();
    }
}


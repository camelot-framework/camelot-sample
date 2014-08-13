package ru.yandex.qatools.camelot.sample.events;

import java.io.Serializable;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 26.06.14
 */
public class Event implements Serializable {
    private int count;

    private int threads;

    public Event() {
        this.count = 0;
        this.threads = 1;
    }

    public Event(int count, int threads) {
        this.count = count;
        this.threads = threads;
    }

    public int getCount() {
        return count;
    }

    public int getThreads() {
        return threads;
    }
}

package ru.yandex.qatools.camelot.sample.events;

import java.io.Serializable;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 26.06.14
 */
public class State implements Serializable {

    private int count;

    public State() {
        count = 0;
    }

    public void inc() {
        count++;
    }
}

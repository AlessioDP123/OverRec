package com.project.overrec.Save;

public interface Savable<T> {
    T save();

    void restore(T restoreObject);
}

/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package list;

import java.util.NoSuchElementException;

public interface ListTemplate<T> {
    int size();
    T get(int index) throws NoSuchElementException;
    void add(T data);
    boolean remove(T data);
    void update(T currData, T newData);
} // end of ListTemplate interface


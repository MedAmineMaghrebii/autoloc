
package tn.esprit.autoloc.service;

import java.util.List;

public interface ServiceI<T> {

    List<T> retrieveAll();

    T retrieveById(Long id);

    T add(T entity);

    T update(T entity);

    void remove(Long id);

}
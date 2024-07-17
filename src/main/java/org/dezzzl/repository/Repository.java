package org.dezzzl.repository;

import java.io.Serializable;

public interface Repository<I extends Serializable, E> {
    E save(E entity);
}

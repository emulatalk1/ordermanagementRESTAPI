package com.vnspectre.ordermanagement.repository;

import com.vnspectre.ordermanagement.domain.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryRepository <T extends Identifiable> {

    @Autowired
    private IdGenerator mIdGenerator;

    private List<T> mElementList = Collections.synchronizedList(new ArrayList<>());

    public T create(T element) {
        mElementList.add(element);
        element.setId(mIdGenerator.getNextId());
        return element;
    }

    public boolean delete(Long id) {
        return mElementList.removeIf(e -> e.getId().equals(id));
    }

    public List<T> findAll() {
        return mElementList;
    }

    public Optional<T> findById(Long id) {
        return mElementList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public int getCount() {
        return mElementList.size();
    }

    public  void clear() {
        mElementList.clear();
    }

    public boolean update(Long id, T updated) {
        if (updated == null) {
            return false;
        } else  {
            Optional<T> element = findById(id);
            element.ifPresent(original -> updateIfExists(original, updated));
            return element.isPresent();
        }
    }

    protected abstract void updateIfExists(T original, T desired);

}

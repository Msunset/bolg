package com.sunset.service;

import com.sunset.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService{

    Type insertType(Type typename);
    Type findType(Long id);
    Page<Type> listPage(Pageable pageable);
    Type update(Long id,Type type);
    void delete(Long id);

}

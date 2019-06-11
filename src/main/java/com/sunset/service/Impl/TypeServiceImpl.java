package com.sunset.service.Impl;

import com.sunset.dao.TypeRepository;
import com.sunset.dao.UserRepository;
import com.sunset.model.Type;
import com.sunset.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    @Transactional
    public Type insertType(Type typename) {
        Type save = typeRepository.save(typename);
        return save;
    }

    @Override
    public Type findType(Long id) {
        return null;
    }

    @Override
    public Page<Type> listPage(Pageable pageable) {
        Page<Type> all = typeRepository.findAll(pageable);
        return all;
    }

    @Override
    public Type update(Long id, Type type) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

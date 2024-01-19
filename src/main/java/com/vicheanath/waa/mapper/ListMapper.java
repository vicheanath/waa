package com.vicheanath.waa.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ListMapper<T,E> {

    @Autowired
    ModelMapper modelMapper;

    /**
     *
     * This method will traverse through a list and map all the elements with a Dto or vice versa
     *
     * @param list This is the list of elements that you want you want to convert to.
     * @param map This is the type of class that it will convert to.
     * @return This will return a generic type holding a list of converted elements (NOTE: Downcast to the wiling type when you call the method)
     */
    public <T, E> List<E> mapList(List<T> list, Class<E> map) {
        return list.stream()
                .map(m -> modelMapper.map(m, map))
                .collect(Collectors.toList());
    }

    public <T, E> E mapObj(T obj, Class<E> map) {
        return modelMapper.map(obj, map);
    }




}
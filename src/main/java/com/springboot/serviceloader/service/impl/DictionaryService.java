package com.springboot.serviceloader.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springboot.serviceloader.service.Dictionary;

/**
 * Created by amitmisra on 2/4/16.
 */
@Component
public class DictionaryService {

    public static final String NO_DEF_FOUND = "No definition found";

    @Autowired
    @Qualifier("dictionaryServiceListFactoryBean")
    Object dictionaries;

    public String getDefinition(String word) {
        Optional<Dictionary> firstNonNullDefinition =  ((List<Dictionary>) dictionaries).stream().filter(p->p.getDefinition(word) != null).findFirst();
        if ( firstNonNullDefinition.isPresent() ) {
            return firstNonNullDefinition.get().getDefinition(word);
        } else {
            return NO_DEF_FOUND;
        }
    }
}

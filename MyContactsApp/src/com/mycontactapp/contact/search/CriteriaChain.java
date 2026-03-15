package com.mycontactapp.contact.search;

import com.mycontactapp.contact.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CriteriaChain {

    private List<SearchCriteria> criteriaList = new ArrayList<>();

    public void addCriteria(SearchCriteria criteria) {

        criteriaList.add(criteria);

    }

    public Predicate<Contact> buildPredicate() {

        Predicate<Contact> predicate = c -> true;

        for(SearchCriteria c : criteriaList){

            predicate = predicate.and(c.toPredicate());

        }

        return predicate;
    }
}
package com.javatechie.couchbase.api.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.javatechie.couchbase.api.model.Customer;
@N1qlPrimaryIndexed
@ViewIndexed(designDoc="customer",viewName="all")
public interface CustomerRepository extends CouchbaseRepository<Customer, Integer>{

}

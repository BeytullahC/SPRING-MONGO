package com.beto.project.sm.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.beto.project.sm.dao.MongoUtilSrv;
import com.beto.project.sm.exceptions.SequenceException;
import com.beto.project.sm.model.document.SequenceId;

@Service(value="mongoUtilImpl")
public class MongoUtilImpl implements MongoUtilSrv {
 
	@Autowired
	private MongoOperations mongo;
	
	@Override	
	public long getNextSequenceId(String key) throws SequenceException {
		 
		Query query = new Query(Criteria.where("_id").is(key));
	 
	        Update update = new Update();
		update.inc("seq", 1);
	 
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
	 
		SequenceId seqId = mongo.findAndModify(query, update, options, SequenceId.class);
	 
		return seqId.getSequence();
	 
	  }
}

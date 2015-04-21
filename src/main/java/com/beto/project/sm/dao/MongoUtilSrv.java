package com.beto.project.sm.dao;

import com.beto.project.sm.exceptions.SequenceException;

public interface MongoUtilSrv {
	
	long getNextSequenceId(String key) throws SequenceException;

}
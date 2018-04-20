package org.foxconn.dao;

import java.util.List;

import org.foxconn.entity.SeagateData1;
import org.springframework.dao.DataAccessException;


public interface SearchdataDao
{
    public  List<List<?>> findData() throws DataAccessException;

 
}
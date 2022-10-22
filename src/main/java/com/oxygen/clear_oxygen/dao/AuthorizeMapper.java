package com.oxygen.clear_oxygen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorizeMapper {

    List<String> getAllMenuByUserId(@Param("userId") long userId);
}

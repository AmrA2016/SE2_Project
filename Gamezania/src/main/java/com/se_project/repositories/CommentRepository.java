package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Comment;



public interface CommentRepository extends CrudRepository<Comment,Long>{
	public List<Comment> findByGid(long gid);
}

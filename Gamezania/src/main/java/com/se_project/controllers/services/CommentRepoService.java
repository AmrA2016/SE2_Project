package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Comment;
import com.se_project.repositories.CommentRepository;


@Service
public class CommentRepoService {
	
	
	
	@Autowired
	private CommentRepository commentRepo;
	
	public void CreateComment(Comment comment){
		commentRepo.save(comment);
	}
	
	public List<Comment> getCommentsByGID(long gid){
		return commentRepo.findByGid(gid);
	}
	

}

package com.se_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se_project.controllers.services.CommentRepoService;
import com.se_project.controllers.services.GameRepositoryService;
import com.se_project.models.Comment;
import com.se_project.models.Game;
import com.se_project.models.Student;

@Controller
public class CommentController {
	
	@Autowired
	GameRepositoryService gameRepoService;
	
	@Autowired
	CommentRepoService commentRepoService;
	
	@RequestMapping(value = "/{student_id}/Course/{cid}/Game/{gameId}/Comment", method = RequestMethod.POST)
	public String AddComment(@RequestParam("commentText")String commentText, @PathVariable String student_id,
			@PathVariable long cid, @PathVariable long gameId )
	{
	  System.out.println(commentText);
	   Comment comment = new Comment();
	   Student student = new Student();
	   student.setUsername(student_id);
	   comment.setStudent(student);
	   comment.setGid(gameId);
	   comment.setComment(commentText);
	   commentRepoService.CreateComment(comment);   
	    
	   return "redirect:/"+ student_id + "/Course/" + cid;
	}
	
}

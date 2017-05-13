package com.se_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.se_project.controllers.services.GameCollaboratorService;

@Controller
public class GameCollaboratorController {
	
	
	@Autowired
	GameCollaboratorService gameCollaboratorService;
    
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/Game/{gameId}/Invite", method = RequestMethod.POST)
	public String invite(@RequestParam String collaboratorId,@PathVariable long cid, @PathVariable long gameId, @PathVariable String teacher_id)
	{
		gameCollaboratorService.inviteTeacher(gameId, collaboratorId);
		
		return "redirect:/" + teacher_id + "/Course/" + cid + "/ViewGame/" + gameId;
	}
	
	@RequestMapping(value = "/{teacher_id}/Accept/{collaboratorID}")
	public String accept(@PathVariable long collaboratorID, @PathVariable String teacher_id)
	{
		gameCollaboratorService.accept(collaboratorID);
		return "redirect:/user/" + teacher_id; 
	}
	
	@RequestMapping(value = "/{teacher_id}/Refuse/{collaboratorID}")
	public String refuse(@PathVariable long collaboratorID, @PathVariable String teacher_id)
	{
		gameCollaboratorService.refuse(collaboratorID);
		return "redirect:/user/" + teacher_id; 
	}
	
	
	
	
	

}

var QuestionNumber =0;
$(function(){
	$(".newQ").click(function(){
		if(QuestionNumber<5){
			QuestionNumber++;
			$("#question"+QuestionNumber).attr("class","");
			
			$("#question"+QuestionNumber+"Title").attr("required","required");
			for(i = 1;i <= 4;i++)
				$("#question"+QuestionNumber+"Choice"+i).attr("required","required");
			
			$(".Question").fadeIn(200);
			$("#numOfQuestions").val(QuestionNumber);
		}
		else{
			alert("Sorry You can't add more than 5 questions")
		}
	});
	
	$(".delQ").click(function(){
		if(QuestionNumber>0){
			
			$("#question"+QuestionNumber).attr("class","hidden");
			$("#question"+QuestionNumber+"Title").removeAttr("required");
			for(i = 1;i <= 4;i++)
				$("#question"+QuestionNumber+"Choice"+i).attr("required","");
			QuestionNumber--;
			$("#numOfQuestions").val(QuestionNumber);
		}
		else{
			alert("Sorry You can't delete any more questions")
		}
	});
	
	$(".TfnewQ").click(function(){
		if(QuestionNumber<5){
			QuestionNumber++;
			$("#question"+QuestionNumber).attr("class","");
			$("#question"+QuestionNumber+"Title").attr("required","required");
			$(".Question").fadeIn(200);
			$("#numOfQuestions").val(QuestionNumber);
		}
		else{
			alert("Sorry You can't add more than 5 questions")
		}
	});
	
	$(".TfdelQ").click(function(){
		if(QuestionNumber>0){
			
			$("#question"+QuestionNumber).attr("class","hidden");
			$("#question"+QuestionNumber+"Title").removeAttr("required");
			QuestionNumber--;
			$("#numOfQuestions").val(QuestionNumber);
		}
		else{
			alert("Sorry You can't delete any more questions")
		}
	});
	
});

function print(limit){
	alert(limit)
	for(var i = 1;i <= limit;i++){
		$("#question"+i).attr("class","");
		$(".Question").fadeIn(200);
	}
}



function newMcqQuestion(){
	var Question = '<h4>Qestion '+ (QuestionNumber+1) +'</h4><div class="Question"><div class="panel panel-default">'
				+'<div class="panel-heading"><input type="text" name="title" th:field="*{questions['+QuestionNumber+ ']}" placeholder="title" class="form-control"></div>'
				+'<div class="panel-body">'
				+'<div class="col-md-3"><input type="text" name="choice1" th:field="*{choices['+QuestionNumber+ '][0]}" placeholder="choice 1" class="form-control"></div>'
				+'<div class="col-md-3"><input type="text" name="choice2" th:field="*{choices['+QuestionNumber+ '][1]}" placeholder="choice 2" class="form-control"></div>'
				+'<div class="col-md-3"><input type="text" name="choice3" th:field="*{choices['+QuestionNumber+ '][2]}" placeholder="choice 3" class="form-control"></div>'
				+'<div class="col-md-3"><input type="text" name="choice4" th:field="*{choices['+QuestionNumber+ '][3]}" placeholder="choice 4" class="form-control"> <br/></div>'
				+'<div class="col-md-3"><input type="text" name="correctAns" th:field="*{correctAnswers['+QuestionNumber+ ']}" placeholder="Right Answer" class="form-control"></div></div></div></div>'
				+'<hr/><span class="newQuestion hidden"></span>';
	QuestionNumber++;
	return Question;
}

function newTfQuestion(){
	
	var Question = '<h4>Qestion '+ (QuestionNumber+1) +'</h4>'
					+'<div class="Question"><div class="panel panel-default">'
					+'<div class="panel-heading">'
						+'<input type="text" name="title" th:field="${tfGame.questions['+QuestionNumber+ ']}" placeholder="title" class="form-control"/>'
					+'</div>'
					+'<div class="panel-body"> <div class="col-md-3">'
					+'<select class="form-control" th:field="${tfGame.correctAnswers['+QuestionNumber+ ']}">'
					+'    <option value="true">True</option>'
					+'    <option value="false">False</option>'
					+'</select>'	
					+'</div></div></div></div>'
					+'<hr/><span class="newQuestion hidden"></span>';	
	
	QuestionNumber++;

	return Question;

}
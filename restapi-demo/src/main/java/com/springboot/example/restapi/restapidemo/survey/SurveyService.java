package com.springboot.example.restapi.restapidemo.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class SurveyService {
	
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1,
		        question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey",
		        "Description of the Survey", questions);

		surveys.add(survey);

	}

	//@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		// TODO Auto-generated method stub
		
		return surveys;
	}

	public List<Survey> retrieveAllSurveysById() {
		
		String surveyId = null;
		Predicate<? super Survey> predicate = 
				survey -> survey.getId()==surveyId;
		Optional<Survey> optionalSurvey=surveys.stream().filter(predicate).findFirst();
		// TODO Auto-generated method stub
		if(optionalSurvey.isEmpty())
			return null;
		return (List<Survey>) optionalSurvey.get();
	}

	public Survey retrieveAllSurveyById(String surveyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> retrieveAllSurveyQuestions(String surveyId) {
		Survey survey = retrieveSurveyById(surveyId);
		if(survey==null)
		// TODO Auto-generated method stub
		return null;
		return survey.getQuestions();
	}
	public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {

		List<Question> surveyQuestions = retrieveAllSurveyQuestions(surveyId);

		if (surveyQuestions == null)
			return null;

		Optional<Question> optionalQuestion = surveyQuestions.stream()
				.filter(q -> q.getId().equalsIgnoreCase(questionId)).findFirst();

		if (optionalQuestion.isEmpty())
			return null;

		return optionalQuestion.get();
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		// TODO Auto-generated method stub
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		question.setId(generateRandomId());
		questions.add(question);
		return question.getId();
	}

	private Object generateRandomId() {
		// TODO Auto-generated method stub
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}

	public Object deleteSurveyQuestion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		List<Question> surveyQuestions = retrieveAllSurveyQuestions(surveyId);

		if (surveyQuestions == null)
			return null;
		

		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		boolean removed = surveyQuestions.removeIf(predicate);
		
		if(!removed) return null;

		return questionId;
	}

	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		// TODO Auto-generated method stub
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
		
	}

}

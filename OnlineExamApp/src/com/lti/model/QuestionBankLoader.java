package com.lti.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public static List<Question> loadQuestionOnJava(){
		QuestionBank qb=new QuestionBank();

		Subject s=new Subject();
		s.setName("Java");
		qb.addNewSubject(s);

		Question q=new Question();
		q.setQuestion ("What is G1 in java?");

		List<Option> ops=new ArrayList<Option>();
		ops.add(new Option("G1 is a Garbage Collector",true));
		ops.add(new Option("G1 is another name for Jeevan",false));
		ops.add(new Option("G1 is the name of a spy agency",false));
		ops.add(new Option("G1 is sequel of Ra.One",false));
		q.setOptions(ops);
		qb.addNewQuestion(s,q);


		q=new Question();
		q.setQuestion ("What is object in Java?");
		ops=new ArrayList<Option>();

		ops.add(new Option("It is an instance of class",true));
		ops.add(new Option("A name given to class",false));
		ops.add(new Option("object of any variable",false));
		ops.add(new Option("none of the above",false));
		q.setOptions(ops);
		qb.addNewQuestion(s,q);

		q=new Question();
		q.setQuestion ("OOPS concepts?");
		ops=new ArrayList<Option>();

		ops.add(new Option("Encapsulation",true));
		ops.add(new Option("Oracle",false));
		ops.add(new Option("JDK",false));
		ops.add(new Option("All of the above",false));
		q.setOptions(ops);
		qb.addNewQuestion(s,q);

		q=new Question();
		q.setQuestion ("Constructor is invoked using which keyword?");
		ops=new ArrayList<Option>();

		ops.add(new Option("new",true));
		ops.add(new Option("final",false));
		ops.add(new Option("exception",false));
		ops.add(new Option("instance",false));
		q.setOptions(ops);
		qb.addNewQuestion(s,q);

		q=new Question();
		q.setQuestion ("We can access private variables from same?");
		ops=new ArrayList<Option>();

		ops.add(new Option("class",true));
		ops.add(new Option("package",false));
		ops.add(new Option("method",false));
		ops.add(new Option("interface",false));
		q.setOptions(ops);
		qb.addNewQuestion(s,q);

		return qb.getQuestionsFor(s);







	}

}

package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Splitter;

public class TransformTextFileToObjects {
	
	private static final Logger logger = Logger.getLogger(TransformTextFileToObjects.class);

	class Question {

		private String question;
		private List<String> possibleAnswers;
		private int answer;

		@Override
		public String toString() {
			return "Question [question=" + question + ", possibleAnswers="
					+ possibleAnswers + ", answer=" + answer + "]";
		}
	}

	Function<String, Question> mapLineToQuestion = new Function<String, Question>() {

		public Question apply(String line) {

			Question question = new Question();

			List<String> questionPieces = Splitter.on("|").trimResults()
					.omitEmptyStrings().splitToList(line);

			question.question = questionPieces.get(0);
			question.possibleAnswers = Splitter.on(",").trimResults()
					.omitEmptyStrings().splitToList(questionPieces.get(1));
			question.answer = Integer.parseInt(questionPieces.get(2));

			return question;
		}
	};

	@Test
	public void test() throws IOException {

		List<Question> questions = Files
				.lines(Paths
						.get("src/test/resources/com/levelup/java/io/trivia.txt"))
				.map(mapLineToQuestion).collect(Collectors.toList());

		logger.info(questions);
		
		assertTrue(questions.size() == 10);
	}

}

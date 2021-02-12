package com.examples.lesson12.services;

import com.examples.lesson12.model.*;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.DefaultHandler2;

public class QuizXmlParser {

  private SAXParser saxParser;

  public QuizXmlParser() throws SAXException, ParserConfigurationException {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    this.saxParser = saxParserFactory.newSAXParser();
  }

  public void addQuestionsToQuiz(Quiz quiz, InputStream inputStream) throws SAXException, IOException {
    saxParser.parse(inputStream, new QuestionFinder(quiz));
  }

  class QuestionFinder extends DefaultHandler2 {

    private final Quiz quiz;
    private Question question;
    private Answer answer;
    private StringBuilder textBuilder = new StringBuilder();
    private Text text = new Text("", false);

    private QuestionFinder(Quiz quiz) {
      this.quiz = quiz;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      flushText();
      if ("QUESTION".equals(qName)) {
        this.question = quiz.addQuestion(attributes.getValue("TITLE"));
      }
      if ("ANSWER".equals(qName)) {
        boolean correct = "true".equalsIgnoreCase(attributes.getValue("ISCORRECT"));
        this.answer = question.addAnswer(correct);
      }
      if ("TEXT".equals(qName)) {
        boolean code = "true".equals(attributes.getValue("CODE"));
        text.setCode(code);
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      flushText();
      if ("QUESTION".equals(qName)) {
        question = null;
      }
      if ("ANSWER".equals(qName)) {
        this.answer = null;
      }
    }

    private void flushText() {
      text.setText(textBuilder.toString());

      if (!text.isEmpty()) {
        if (answer != null) {
          answer.add(text);
        } else if (question != null) {
          question.add(text);
        }
      }

      text = new Text();
      textBuilder = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      textBuilder.append(ch, start, length);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
      if (quiz != null) {
        quiz.setError(true);
      }
    }
  }
}

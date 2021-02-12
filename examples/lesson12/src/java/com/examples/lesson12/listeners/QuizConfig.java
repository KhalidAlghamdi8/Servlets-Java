package com.examples.lesson12.listeners;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class QuizConfig {

  private String name;
  private List<String> sources = new ArrayList<String>();
  private String description;
  private int questionCount;

  private QuizConfig() {
  }

  public static Iterable<QuizConfig> create(InputStream resourceAsStream) {
    List<QuizConfig> configs = new ArrayList<QuizConfig>();
    if (resourceAsStream != null) {
      try {
        loadQuizzes(configs, resourceAsStream);
      } catch (Exception ex) {
        Logger.getLogger(QuizConfig.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return configs;
  }

  private static void loadQuizzes(List<QuizConfig> configs, InputStream resourceAsStream) throws SAXException, ParserConfigurationException, IOException {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbFactory.newDocumentBuilder();
    Document doc = db.parse(resourceAsStream);
    for (int j = 0; j < doc.getChildNodes().getLength(); j++) {
      Node quizzes = doc.getChildNodes().item(j);
      if ("quizzes".equals(quizzes.getNodeName())) {
        for (int i = 0; i < quizzes.getChildNodes().getLength(); i++) {
          Node quiz = quizzes.getChildNodes().item(i);
          if ("quiz".equals(quiz.getNodeName())) {
            configs.add(buildConfig(quiz));
          }
        }
      }
    }
  }

  private static QuizConfig buildConfig(Node quiz) {
    QuizConfig config = new QuizConfig();
    for (int i = 0; i < quiz.getChildNodes().getLength(); i++) {
      Node node = quiz.getChildNodes().item(i);
      String nodeName = node.getNodeName();
      if ("name".equals(nodeName.toLowerCase())) {
        config.name = node.getTextContent();
      } else if ("description".equals(nodeName.toLowerCase())) {
        config.description = node.getTextContent();
      } else if ("questioncount".equals(nodeName.toLowerCase())) {
        try {
          String textContent = node.getTextContent();
          if (textContent != null && textContent.trim().length() > 0) {
            config.questionCount = Integer.parseInt(textContent);
          }
        } catch (Exception e) {
          Logger.getLogger(QuizConfig.class.getName()).log(Level.WARNING, null, e);
        }
      } else if ("sources".equals(nodeName.toLowerCase())) {
        addSources(config, node);
      }
    }
    return config;
  }

  private static void addSources(QuizConfig config, Node node) {
    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
      Node source = node.getChildNodes().item(i);
      if ("source".equals(source.getNodeName())) {
        config.sources.add(source.getTextContent());
      }
    }

  }

  public String getName() {
    return name;
  }

  public Iterable<String> getSources() {
    return sources;
  }

  public String getDescription() {
    return description;
  }

  public int getQuestionCount() {
    return questionCount;
  }
}

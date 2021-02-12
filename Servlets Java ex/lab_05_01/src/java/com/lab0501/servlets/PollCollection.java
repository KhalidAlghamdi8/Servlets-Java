package com.lab0501.servlets;

import java.util.HashMap;
import java.util.Map;

public class PollCollection {

  private Map<String, Poll> polls = new HashMap<String, Poll>();

  public Poll getPoll(String name) {
    Poll poll = polls.get(name);
    if (poll == null) {
      poll = new Poll(name);
      polls.put(name, poll);
    }
    return poll;
  }
}

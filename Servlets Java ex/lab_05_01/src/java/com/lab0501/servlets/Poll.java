package com.lab0501.servlets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Poll {

  private Map<String, Integer> votes = new HashMap<String, Integer>();
  private final String name;

  public Poll(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void vote(String option) {
    Integer vote = votes.get(option);
    if(vote == null){
      vote =0;
    }
    vote++;
    votes.put(option, vote);
  }
  public Collection<Map.Entry<String, Integer>> getVotes(){
    return votes.entrySet();
  }
}

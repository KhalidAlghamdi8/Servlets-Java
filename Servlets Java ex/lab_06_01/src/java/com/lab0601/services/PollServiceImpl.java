package com.lab0601.services;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PollServiceImpl implements PollService {

  private final Map<String, Integer> options;

  public PollServiceImpl() {
    options = new HashMap<String, Integer>();
    options.put("red", Integer.valueOf(0));
    options.put("green", Integer.valueOf(0));
    options.put("blue", Integer.valueOf(0));
  }

  @Override
  public void vote(String option) {
    Integer votes = options.get(option);
    if (votes != null) {
      votes++;
      options.put(option, votes);
    }
  }

  @Override
  public String[] getOptions() {
    return options.keySet().toArray(new String[]{});
  }

  @Override
  public int getVotes(String option) {
    Integer votes = options.get(option);
    if (votes != null) {
      return votes;
    } else {
      return 0;
    }
  }
}

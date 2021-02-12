package com.lab0601.model;

/**
 * A simple bean for JSP display
 */
public class PollResult {

  private final String option;
  private final int votes;

  public PollResult(String option, int votes) {
    this.option = option;
    this.votes = votes;
  }

  public String getOption() {
    return option;
  }

  public int getVotes() {
    return votes;
  }
}

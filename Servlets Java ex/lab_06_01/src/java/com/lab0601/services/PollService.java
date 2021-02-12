package com.lab0601.services;

/**
 * This service allows you to cast votes on options as well as get all the
 * available options and votes.
 */
public interface PollService {

  /**
   * Votes for an option
   *
   * @param option The option you voted for.
   */
  public void vote(String option);

  /**
   * Gets the available options.
   *
   * @return An array of options.
   */
  public String[] getOptions();

  /**
   * Returns the votes for an option.
   *
   * @param option the option.
   * @return the number of votes the option has.
   */
  public int getVotes(String option);
}

package com.examples.lesson08.simpleTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HeaderSimpleTag extends SimpleTagSupport {

  private String title;

  @Override
  public void doTag() throws JspException {
    JspWriter out = getJspContext().getOut();
    try {
      out.println("<h1>" + title + "</h1>");
    } catch (java.io.IOException ex) {
      throw new JspException("Error in HeaderSimpleTag tag", ex);
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }
}

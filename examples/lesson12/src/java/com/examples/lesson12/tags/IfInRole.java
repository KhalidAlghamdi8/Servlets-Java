package com.examples.lesson12.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfInRole extends SimpleTagSupport {

  private String role;

  @Override
  public void doTag() throws JspException {
    try {
      PageContext context = (PageContext) getJspContext();
      HttpServletRequest request = (HttpServletRequest) context.getRequest();
      if (request.isUserInRole(role)) {
        getJspBody().invoke(null);
      }
    } catch (Exception ex) {
      throw new JspException("Error in IfInRole tag", ex);
    }
  }

  public void setRole(String role) {
    this.role = role;
  }
}

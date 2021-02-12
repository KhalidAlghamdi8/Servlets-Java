package GuessGameBean;


import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khalid
 */
@Named(value = "guessGameBean")
@SessionScoped
public class GuessGameBean implements Serializable{

    private int answer;
    private int guess;
    
    public GuessGameBean() {
    }
    
    public void checkAnswer(){
        String reaultMsg="";
        if (this.answer > this.guess) {
            reaultMsg = "high";
        } else if (this.answer < this.guess){
            reaultMsg = "low";
        } else {
            reaultMsg=" Good Guess";
     }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(reaultMsg));
    }
    @PostConstruct
    public void generatRandomGuess (){
            this.answer = 0;
        this.guess = (new Random()).nextInt(100);
     //   Logger.getLogger(GuessGameBean.class).log(Level.INFO, "Guessed Number is:" + this.guess);
        

    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
    
}

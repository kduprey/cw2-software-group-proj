package main.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ScreenSwitch extends JPanel {

    private CardLayout layout;
    private HashMap<String, BasePanel> cards;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId = null;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    private String userType = null;

    public ScreenSwitch(){
        CardLayout cards = new CardLayout();
        this.layout = cards;
        this.setLayout(cards);
        this.cards= new HashMap<>();
    }

    public void show(String card){
        this.layout.show(this, card);
    }


    public HashMap<String, BasePanel> getCards() {
        return cards;
    }

    public void setCards(HashMap<String, BasePanel> cards) {
        this.cards = cards;
    }

    public void add(BasePanel comp, Object obj){
        super.add(comp, obj);
        cards.put((String) obj, comp);
    }
}

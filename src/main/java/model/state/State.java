package model.state;

import model.Model;

public interface State {
     void keyPressedI (Model model);
     void keyPressedUP (Model model);
     void keyPressedDOWN (Model model);
     void keyPressedLEFT (Model model);
     void keyPressedRIGHT (Model model);
     void keyPressedA(Model model);
     void keyPressedZ(Model model);
     void keyPressedE(Model model);
     void keyPressedENTER (Model model);
}

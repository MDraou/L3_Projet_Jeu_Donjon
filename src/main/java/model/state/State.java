package model.state;

import model.Model;

public interface State {
     void keyPressedI (Model model);
     void keyPressedUP (Model model);
     void keyPressedDOWN (Model model);
     void keyPressedLEFT (Model model);
     void keyPressedRIGHT (Model model);
     void keyPressedDIGIT1 (Model model);
     void keyPressedDIGIT2 (Model model);
     void keyPressedDIGIT3 (Model model);
     void keyPressedENTER (Model model);
}

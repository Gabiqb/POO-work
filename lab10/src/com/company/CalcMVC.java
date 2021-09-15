package com.company;

public class CalcMVC {
    CalcModel model = new CalcModel();
    CalcView view = new CalcView(model);
    CalcController controller = new CalcController(model, view);
}

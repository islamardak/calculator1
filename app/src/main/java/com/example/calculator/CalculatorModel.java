package com.example.calculator;

import java.util.TreeSet;

public class CalculatorModel {
    int firstArg;
    int secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSeleced;

    private State state;

    private enum State{
        firstApgInput,
        secondInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstApgInput;
    }
    public void onNumPressed(int buttonId) {

        if (state == State.resultShow){
            state = State.firstApgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.zero:
                    if (inputStr.length() != 0){
                        inputStr.append("0");
                    }
                    break;
                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;

            }
        }
    }
    public void onActionPressed(int actionId){

        if (actionId == R.id.equals &&  state == State.secondInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSeleced){
                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.division:
                    inputStr.append(firstArg / secondArg);
                    break;

            }

        }else if (inputStr.length()>0 && state == State.firstApgInput){
            firstArg = Integer.parseInt(inputStr.toString());
                state  = State.secondInput;
            inputStr.setLength(0);

            switch (actionId) {
                case R.id.plus:
                    actionSeleced = R.id.plus;
                    break;
                case R.id.minus:
                    actionSeleced = R.id.minus;
                    break;
                case R.id.multiply:
                    actionSeleced = R.id.multiply;
                    break;
                case R.id.division:
                    actionSeleced = R.id.division;
                    break;

            }


            }
        }

    public String getText() {
        return inputStr.toString();
    }
}


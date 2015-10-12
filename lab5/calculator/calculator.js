// CALCULATOR.JS
//
//
//


var Calc = {

    Model: {
        // We set all the values here to null as these are set/unset by the action handlers
        previousAction: {
            action: null,
            value: null
        },
        storedAction: {
            action: null,
            value: null
        },
        memory: {
            value: 0
        },
        clearFlag: false


    },


    View: {
        textRow: {id: "textRow", type: "text", disabled: true, value: "", onclick: ""},
        buttonC: {id: "buttonC", type: "button", value: 'C', onclick: ""},
        rows: {
            buttonsRow1: {
                button7: {id: "button7", type: "button", value: 7, onclick: ""},
                button8: {id: "button8", type: "button", value: 8, onclick: ""},
                button9: {id: "button9", type: "button", value: 9, onclick: ""},
                buttonPlus: {id: "buttonPlus", class: 'number_action', type: "button", value: '+', onclick: ""}
            },
            buttonsRow2: {
                button4: {id: "button4", type: "button", value: 4, onclick: ""},
                button5: {id: "button5", type: "button", value: 5, onclick: ""},
                button6: {id: "button6", type: "button", value: 6, onclick: ""},
                buttonMinus: {id: "buttonMinus", class: 'number_action', type: "button", value: '-', onclick: ""}
            },
            buttonsRow3: {
                button1: {id: "button1", type: "button", value: 1, onclick: ""},
                button2: {id: "button2", type: "button", value: 2, onclick: ""},
                button3: {id: "button3", type: "button", value: 3, onclick: ""},
                buttonMultiply: {id: "buttonMultiply", class: 'number_action', type: "button", value: '*', onclick: ""}
            },
            buttonsRow4: {
                button0: {id: "button8", type: "button", value: 0, onclick: ""},
                buttonDecimal: {id: "buttonDecimal", type: "button", value: '.', onclick: ""},
                buttonEquals: {id: "buttonEquals", class: 'number_action', type: "button", value: '=', onclick: ""},
                buttonDivides: {id: "buttonDivides", class: 'number_action', type: "button", value: '/', onclick: ""}
            },
            buttonsRow5: {
                buttonMC: {id: "buttonMC", class: 'memory_action', type: "button", value: 'MC', onclick: ""},
                buttonMR: {id: "buttonMR", class: 'memory_action', type: "button", value: 'MR', onclick: ""},
                buttonMMinus: {id: "buttonMMinus", class: 'memory_action', type: "button", value: 'M-', onclick: ""},
                buttonMPlus: {id: "buttonPlus", class: 'memory_action', type: "button", value: 'M+', onclick: ""}
            }
        }
    },

    Controller: {
        /**
         * A function called by number buttons to handle putting the number in the input field
         * @param button the button that was pressed.
         */
        numberButtonHandler: function (button) {
            // Makes sure to avoid any null reference exceptions.
            var textRow = document.getElementById(Calc.View.textRow.id);

            if (textRow.value === null || textRow.value === '' || window.model.clearFlag) textRow.value = button.value;
            else textRow.value = textRow.value + button.value;
            window.model.clearFlag = false;
        },
        numberActionHandler: function (button) {
            var model = window.model;
            var textRow = document.getElementById(Calc.View.textRow.id);
            // We will not support if the calculator is blank
            if (textRow.value === null || textRow.value === '') return;
            switch(button.value){
                case '+':
                case '-':
                case '/':
                case '*':
                    if(model.storedAction.action != null) return;
                    model.storedAction.action = button.value;
                    model.storedAction.value = textRow.value;
                    textRow.value = textRow.value + button.value;
                    model.clearFlag = true;
                    break;
                case '=':
                    // We got 2 cases: one is if they repeatedly hit the equals button and the other is when there is something in the stored procedure
                    if(model.storedAction.action != null){
                        // Ok, we got a stored action, time to send the correct data and store it properly.
                        model.previousAction.value = textRow.value;
                        textRow.value = Calc.Controller.mathHandler(model.storedAction.value, textRow.value, model.storedAction.action);
                        model.previousAction.action = model.storedAction.action;
                        model.storedAction.value = null;
                        model.storedAction.action = null;
                        model.clearFlag = true;
                    }
                    else if(model.previousAction.action != null){
                        // Ok, so we another iteration of the same thing.
                        textRow.value = Calc.Controller.mathHandler(textRow.value, model.previousAction.value, model.previousAction.action);
                    }
                    else return;
                    break;
            }
        },
        memoryActionHandler: function (button) {
            var action = button.value;
            var textRow = document.getElementById(Calc.View.textRow.id);
            var memory = window.model.memory;
            switch(action) {
                case 'MR':
                    textRow.value = memory.value;
                    window.model.clearFlag = true;
                    break;
                case 'MC':
                    memory.value = 0;
                    break;
                case 'M-':
                case 'M+':
                    if (textRow.value === null || textRow.value === '') return;
                    memory.value = Calc.Controller.mathHandler(memory.value, textRow.value, action.substr(1,2));
                    break;
            }
        },
        mathHandler: function (value1, value2, action){
            var a1 = Number(value1), a2 = Number(value2);
            switch(action) {
                case '+':
                    return a1 + a2;
                case '-':
                    return a1 - a2;
                case '/':
                    return a1 / a2;
                case '*':
                    return a1 * a2;
            }
        },
        clearHandler: function() {
            var textRow = document.getElementById(Calc.View.textRow.id);
            textRow.value = '';
            window.model.clearFlag = false;
            window.model.storedAction.action = null;
            window.model.storedAction.value = null;
        }
    },

    run: function () {
        // adding this CSS to make sure everything looks good.
        var css = "#textrow{width:100%;height:2rem}input[type=button]{width:3rem!important;height:3rem!important;vertical-align:middle;text-align:center;-webkit-appearance:none;border:1px solid grey;background:-webkit-linear-gradient(top,#fcfcfc,#e5e5e5);background:-o-linear-gradient(bottom,#fcfcfc,#e5e5e5);background:-moz-linear-gradient(bottom,#fcfcfc,#e5e5e5);background:linear-gradient(to bottom,#fcfcfc,#e5e5e5);font:400 15px helvetica,arial,sans-serif;padding:6px}input[type=text]{-webkit-appearance:none;text-align:right}input{-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px}table,td,tr{border:none}",
            head = document.head || document.getElementsByTagName('head')[0],
            style = document.createElement('style');

        style.type = 'text/css';
        if (style.styleSheet){
            style.styleSheet.cssText = css;
        } else {
            style.appendChild(document.createTextNode(css));
        }

        head.appendChild(style);

        window.model = Calc.Model;
        Calc.attachHandlers();
        return Calc.display();
    },


    displayElement: function (element) {
        var s = "<input ";
        s += " id=\"" + element.id + "\"";
        s += " class=\"" + element.class + "\"";
        s += " type=\"" + element.type + "\"";
        s += " value= \"" + element.value + "\"";
        s += " onclick= \"" + element.onclick + "\"";
        if (element.disabled) s += " disabled ";
        s += ">";
        return s;

    },

    display: function () {
        var s;
        s = "<table id=\"myTable\" border=2>";
        s += "<tr><td colspan='3'>" + Calc.displayElement(Calc.View.textRow) + "</td><td>" + Calc.displayElement(Calc.View.buttonC) + "</td></tr>";
        // Iterate through all of the rows/props and display the buttons
        for (var row in Calc.View.rows) {
            s += "<tr>";
            //noinspection JSUnfilteredForInLoop
            for (var button in Calc.View['rows']['' + row]) {
                s += "<td>" +
                    Calc.displayElement(Calc.View['rows']['' + row]['' + button]) +
                    "</td>";
            }
            s += "</tr>";
        }
        s += "</table>";
        return s;
    },

    attachHandlers: function () {
        //Calc.View.buttonsRow1.button7.onclick = "Calc.button7Handler()";
        Calc.View.buttonC.onclick = "Calc.Controller.clearHandler()";
        // Iterate through them and ensure the proper handler is set.
        for (var row in Calc.View.rows) {
            //noinspection JSUnfilteredForInLoop
            for (var button in Calc.View['rows']['' + row]) {
                switch (Calc.View['rows']['' + row]['' + button].class) {
                    case "number_action":
                        Calc.View['rows']['' + row]['' + button].onclick = "Calc.Controller.numberActionHandler(this)";
                        break;
                    case "memory_action":
                        Calc.View['rows']['' + row]['' + button].onclick = "Calc.Controller.memoryActionHandler(this)";
                        break;
                    default :
                        Calc.View['rows']['' + row]['' + button].onclick = "Calc.Controller.numberButtonHandler(this)";
                        break;

                }
            }
        }
    }

}; // end of Calc;

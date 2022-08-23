grammar StelyLang;

program: statements+;

statements: let | output;

let: VAR '=' INT ;

output: 'output' (INT | VAR);

VAR: ('a'..'z' | 'A'.. 'Z')+ ;
INT: '0'..'9'+;
WS: ['', \n\r\t]+ -> skip;


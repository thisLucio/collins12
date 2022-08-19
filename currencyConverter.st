pack Stely;

main{
    currency_converter();
}

function void currency_converter {
    float dolar = 5.17;

    float _input;

    stely.input(_input);

    stely.output(_input * dolar);

}
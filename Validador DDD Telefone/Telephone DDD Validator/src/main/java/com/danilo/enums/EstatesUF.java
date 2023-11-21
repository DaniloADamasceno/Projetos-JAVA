package com.danilo.enums;

public enum EstatesUF {

    // Centro-Oeste
    MS(50),
    MT(51),
    GO(52),
    DF(53),

    // NORDESTE
    MA(21),
    PI(22),
    CE(23),
    RN(24),
    PB(25),
    PE(26),
    AL(27),
    SE(28),
    BA(29),

    // NORTE
    RO(11),
    AC(12),
    AM(13),
    RR(14),
    PA(15),
    AP(16),
    TO(17),

    // SUDESTE
    MG(31),
    ES(32),
    RJ(33),
    SP(35),

    // SUL
    PR(41),
    SC(42),
    RS(43);

    private final Integer UF;

    EstatesUF(Integer UF) {
        this.UF = UF;
    }

    // ----------------------------------------   GETTERS AND SETTERS   ------------------------------------------------
    public Integer getUF() {
        return UF;
    }
}

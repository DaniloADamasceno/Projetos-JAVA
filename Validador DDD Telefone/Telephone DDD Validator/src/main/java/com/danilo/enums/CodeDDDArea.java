package com.danilo.enums;

import lombok.Getter;

@Getter
public enum CodeDDDArea {
    // Centro-Oeste
    DISTRITO_FEDERAL (61),
    GOIAS (62, 64),
    MATO_GROSSO (65, 66),
    MATO_GROSSO_DO_SUL (67),

    // NORDESTE
    ALAGOAS (82),
    BAHIA (71, 73, 74, 75, 77),
    CEARA (85, 88),
    MARANHAO (98, 99),
    PARAIBA (83),
    PERNAMBUCO (81, 87),
    PIAUI (86, 89),
    RIO_GRANDE_DO_NORTE (84),
    SERGIPE (79),

    // NORTE
    ACRE (68),
    AMAPA (96),
    AMAZONAS (92, 97),
    PARA (91, 93, 94),
    RONDONIA (69),
    RORAIMA (95),
    TOCANTINS (63),

    // SUDESTE
    ESPIRITO_SANTO (27, 28),
    MINAS_GERAIS (31, 32, 33, 34, 35, 37, 38),
    RIO_DE_JANEIRO (21, 22, 24),
    SAO_PAULO (11, 12, 13, 14, 15, 16, 17, 18, 19),

    // SUL
    PARANA (41, 42, 43, 44, 45, 46),
    RIO_GRANDE_DO_SUL (51, 53, 54, 55),
    SANTA_CATARINA (47, 48, 49),

    LANDLINE(2, 3 , 4, 5, 7);

    public static final int DDD_CODE_AREA_LENGTH = 2;
    public final Integer[] DDD;

    // --------------------------------------------   CONSTRUCTOR   -------------------------------------------------- //
    private CodeDDDArea(Integer... DDD) {
        this.DDD = DDD;
    }

    public static int getDDDCodeAreaLength() {
        return DDD_CODE_AREA_LENGTH;
    }
}

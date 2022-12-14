package com.hope.dentistoffice.models.domainmodels;

import java.math.BigDecimal;

public record Visit(Integer ID, BigDecimal cost, String description) {
}

package fr.starn.energybillmanager.dto;

import java.util.Date;

public record CostDTO(long clientId, Date startDate, Date endDate, double amount) {}

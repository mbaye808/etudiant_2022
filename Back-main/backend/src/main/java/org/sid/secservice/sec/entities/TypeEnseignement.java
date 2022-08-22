package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The TypeEnseignement enumeration.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public enum TypeEnseignement {
    CM, TD, TP, DS,CC
}

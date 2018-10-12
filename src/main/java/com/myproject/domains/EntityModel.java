package com.myproject.domains;

import java.io.Serializable;

@FunctionalInterface
public interface EntityModel extends Serializable {

    Serializable getId();

}


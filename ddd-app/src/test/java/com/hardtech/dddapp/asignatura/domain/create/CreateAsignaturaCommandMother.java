package com.hardtech.dddapp.asignatura.domain.create;

public final class CreateAsignaturaCommandMother {

  public static CreateAsignaturaCommand invalidId() {
    return CreateAsignaturaCommand.builder()
        .id("123")
        .name("Castellano")
        .creditNumber(1)
        .build();
  }

  public static CreateAsignaturaCommand nullName() {
    return CreateAsignaturaCommand.builder()
        .id("0e2febf5-9e09-49b9-9a71-16195cf5d7f8")
        .name(null)
        .creditNumber(1)
        .build();
  }

  public static CreateAsignaturaCommand emptyName() {
    return CreateAsignaturaCommand.builder()
        .id("0e2febf5-9e09-49b9-9a71-16195cf5d7f8")
        .name("")
        .creditNumber(1)
        .build();
  }

  public static CreateAsignaturaCommand valid() {
    return CreateAsignaturaCommand.builder()
        .id("0e2febf5-9e09-49b9-9a71-16195cf5d7f8")
        .name("ingles")
        .creditNumber(1)
        .build();
  }
}

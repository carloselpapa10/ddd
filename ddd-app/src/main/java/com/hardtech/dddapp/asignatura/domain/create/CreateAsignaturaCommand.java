package com.hardtech.dddapp.asignatura.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Create Asignatura Command
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateAsignaturaCommand {
  private String id;
  private String name;
  private int creditNumber;
}

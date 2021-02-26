package com.hardtech.dddapp.asignatura.application.create;

import com.hardtech.dddapp.asignatura.domain.Asignatura;
import com.hardtech.dddapp.asignatura.domain.AsignaturaCreditNumber;
import com.hardtech.dddapp.asignatura.domain.AsignaturaId;
import com.hardtech.dddapp.asignatura.domain.AsignaturaName;
import com.hardtech.dddapp.asignatura.domain.IAsignaturaService;
import com.hardtech.dddapp.asignatura.domain.create.CreateAsignaturaCommand;
import com.hardtech.dddapp.asignatura.domain.create.ICreateAsignatura;
import com.hardtech.dddapp.asignatura.domain.exceptions.AsignaturaIdAlreadyExistsException;

/**
 * Create Asignatura Use Case
 */
public class CreateAsignatura implements ICreateAsignatura {

  private final IAsignaturaService asignaturaService;

  /**
   * Constructor
   *
   * @param asignaturaService The asignatura service
   */
  public CreateAsignatura(IAsignaturaService asignaturaService) {
    this.asignaturaService = asignaturaService;
  }

  @Override
  public Asignatura execute(CreateAsignaturaCommand asignaturaCommand) {
    var id = new AsignaturaId(asignaturaCommand.getId());
    var name = new AsignaturaName(asignaturaCommand.getName());
    var creditNumber = new AsignaturaCreditNumber(asignaturaCommand.getCreditNumber());

    var asignaturaOptional = asignaturaService.findAsignaturaById(id);
    if (asignaturaOptional.isPresent()) {
      throw new AsignaturaIdAlreadyExistsException(id.value());
    }

    var asignatura = Asignatura.build(id, name, creditNumber);
    asignaturaService.saveAsignatura(asignatura);

    return asignatura;
  }
}

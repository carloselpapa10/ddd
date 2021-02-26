package com.hardtech.dddapp.asignatura.application.create;

import com.hardtech.dddapp.asignatura.domain.Asignatura;
import com.hardtech.dddapp.asignatura.domain.AsignaturaId;
import com.hardtech.dddapp.asignatura.domain.IAsignaturaService;
import com.hardtech.dddapp.asignatura.domain.create.CreateAsignaturaCommandMother;
import com.hardtech.dddapp.asignatura.domain.create.ICreateAsignatura;
import com.hardtech.dddapp.asignatura.domain.exceptions.AsignaturaNameCanNotBeNullNorEmptyException;
import com.hardtech.dddapp.shared.domain.exception.IdentifierMalformedException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateAsignaturaTests {

  private final ICreateAsignatura createAsignatura;
  @Mock
  private IAsignaturaService asignaturaService;

  public CreateAsignaturaTests() {
    openMocks(this);
    createAsignatura = new CreateAsignatura(asignaturaService);
  }

  @Test
  public void Throw_Exception_When_Id_Is_Malformed() {
    var createAsignaturaCommand = CreateAsignaturaCommandMother.invalidId();

    var exception = assertThrows(IdentifierMalformedException.class,
        () -> createAsignatura.execute(createAsignaturaCommand),
        "Validate asignatura id is malformed exception");

    assertThat(exception.getMessage()).isEqualTo(String.format("The identifier <%s> is malformed",
        createAsignaturaCommand.getId()));
  }

  @Test
  public void Throw_Exception_When_Name_Is_Null() {
    var createAsignaturaCommand = CreateAsignaturaCommandMother.nullName();

    var exception = assertThrows(AsignaturaNameCanNotBeNullNorEmptyException.class,
        () -> createAsignatura.execute(createAsignaturaCommand),
        "Validate asignatura name is null exception");

    assertThat(exception.getMessage()).isEqualTo("El nombre de la asignatura no puede ser vacio o nulo");
  }

  @Test
  public void Throw_Exception_When_Name_Is_Empty() {
    var createAsignaturaCommand = CreateAsignaturaCommandMother.emptyName();

    var exception = assertThrows(AsignaturaNameCanNotBeNullNorEmptyException.class,
        () -> createAsignatura.execute(createAsignaturaCommand),
        "Validate asignatura name is empty");

    assertThat(exception.getMessage()).isEqualTo("El nombre de la asignatura no puede ser vacio o nulo");
  }

  @Test
  public void Create_Asignatura() {
    var createAsignaturaCommand = CreateAsignaturaCommandMother.valid();

    when(asignaturaService.findAsignaturaById(new AsignaturaId(createAsignaturaCommand.getId())))
        .thenReturn(Optional.empty());

    var result = createAsignatura.execute(createAsignaturaCommand);

    assertNotNull(result);
    assertThat(result.getId().value()).isEqualTo(createAsignaturaCommand.getId());
    assertThat(result.getName().value()).isEqualTo(createAsignaturaCommand.getName());
    assertThat(result.getCreditNumber().value()).isEqualTo(createAsignaturaCommand.getCreditNumber());

    verify(asignaturaService).findAsignaturaById(new AsignaturaId(createAsignaturaCommand.getId()));
    verify(asignaturaService, times(1)).saveAsignatura(any(Asignatura.class));
  }
}

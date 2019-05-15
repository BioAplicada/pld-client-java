package io.apihub.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Nombre completo de la persona a consultar.")

public class Peticion {
  @SerializedName("nombres")
  private String nombres = null;

  @SerializedName("apellidoPaterno")
  private String apellidoPaterno = null;

  @SerializedName("apellidoMaterno")
  private String apellidoMaterno = null;

  public Peticion nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }

  @ApiModelProperty(example = "MIGUEL ANGEL", required = true, value = "Nombre completo de la persona.")
  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public Peticion apellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
    return this;
  }

  @ApiModelProperty(example = "SAHAGUN", required = true, value = "Apellido paterno de la persona.")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public Peticion apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }

  @ApiModelProperty(example = "ZARAGOZA", required = true, value = "Apellido materno de la persona.")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Peticion peticion = (Peticion) o;
    return Objects.equals(this.nombres, peticion.nombres) &&
        Objects.equals(this.apellidoPaterno, peticion.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, peticion.apellidoMaterno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombres, apellidoPaterno, apellidoMaterno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Peticion {\n");
    
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

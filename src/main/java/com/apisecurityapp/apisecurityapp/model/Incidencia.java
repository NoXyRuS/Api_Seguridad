package com.apisecurityapp.apisecurityapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incidencia")
@NamedStoredProcedureQueries(value = {
        @NamedStoredProcedureQuery(name = "f_insertar_incidencia1", procedureName = "f_insertar_incidencia1", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idusuario", type = int.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_ubicacion", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_estado", type = int.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_tipo", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_latitud", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_longitud", type = String.class)
        }),
})
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idincidencia")
    private Long id;  // La clave primaria

    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    private int idusuario;  // Relación con la entidad 'Usuario'

    @Temporal(TemporalType.DATE)  // Solo la fecha, sin la hora
    @Column(nullable = false)
    private LocalDate fecha;  // Cambiar LocalDateTime a LocalDate

    @Column(name = "ubicacion", columnDefinition = "TEXT")
    private String ubicacion;

    @Column(name = "estado", columnDefinition = "integer default 1")
    private Integer estado;  // Estado de la incidencia (1: Registrado, 2: Atendido, 3: Solucionado)

    @Column(name = "tipo", columnDefinition = "TEXT")
    private String tipo;

    // Nuevas columnas: latitud y longitud
    @Column(name = "latitud", precision = 10, scale = 6)
    private Double latitud;  // Latitud con precisión de 6 decimales

    @Column(name = "longitud", precision = 10, scale = 6)
    private Double longitud;  // Longitud con precisión de 6 decimales

    public Incidencia(Long id, int idusuario, LocalDate fecha, String ubicacion, int estado, String tipo, Double latitud, Double longitud) {
        this.id = id;
        this.idusuario = idusuario;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipo = tipo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Incidencia() {

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "id=" + id +
                ", idusuario=" + idusuario +
                ", fecha=" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado=" + estado +
                ", tipo='" + tipo + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}

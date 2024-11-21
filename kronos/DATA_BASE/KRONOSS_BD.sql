CREATE DATABASE kron
USE kron


-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY, -- ID definido manualmente para usuarios
    nombre_completo VARCHAR(MAX),
    edad INT,
    telefono VARCHAR(MAX),
    correo VARCHAR(MAX),
    contrasena VARCHAR(MAX)
);

-- Crear la tabla de recordatorios
CREATE TABLE recordatorios (
    id_recordatorio INT PRIMARY KEY, -- ID definido manualmente para recordatorios
    id_usuario INT,
    titulo VARCHAR(MAX),
    fecha_hora_recordatorio DATETIME,
    intervalo_repeticion VARCHAR(MAX),
    estado VARCHAR(MAX),
    descripcion VARCHAR(MAX),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Crear la tabla de notificaciones
CREATE TABLE notificaciones (
    id_notificacion INT PRIMARY KEY, -- ID definido manualmente para notificaciones
    id_recordatorio INT,
    fecha_hora_notificacion DATETIME,
    FOREIGN KEY (id_recordatorio) REFERENCES recordatorios(id_recordatorio)
);

CREATE PROCEDURE AgregarUsuario
    @id_usuario INT,
    @nombre_completo VARCHAR(MAX),
    @edad INT,
    @telefono VARCHAR(MAX),
    @correo VARCHAR(MAX),
    @contrasena VARCHAR(MAX)
AS
BEGIN
    INSERT INTO usuarios (id_usuario, nombre_completo, edad, telefono, correo, contrasena)
    VALUES (@id_usuario, @nombre_completo, @edad, @telefono, @correo, @contrasena);
END;


EXEC AgregarUsuario @id_usuario = 1, @nombre_completo = 'Juan Perez', @edad = 30, @telefono = '123456789', @correo = 'juan@mail.com', @contrasena = 'pass123';

select*from usuarios



CREATE PROCEDURE AgregarRecordatorio
    @id_recordatorio INT,
    @id_usuario INT,
    @titulo VARCHAR(MAX),
    @fecha_hora_recordatorio DATETIME,
    @intervalo_repeticion VARCHAR(MAX),
    @estado VARCHAR(MAX),
    @descripcion VARCHAR(MAX)
AS
BEGIN
    INSERT INTO recordatorios (id_recordatorio, id_usuario, titulo, fecha_hora_recordatorio, intervalo_repeticion, estado, descripcion)
    VALUES (@id_recordatorio, @id_usuario, @titulo, @fecha_hora_recordatorio, @intervalo_repeticion, @estado, @descripcion);
END;

EXEC AgregarRecordatorio @id_recordatorio = 1, @id_usuario = 1, @titulo = 'Recordatorio 1', @fecha_hora_recordatorio = '2024-11-20 10:00', @intervalo_repeticion = 'Diario', @estado = 'Activo', @descripcion = 'Descripción del recordatorio';


CREATE PROCEDURE AgregarNotificacion
    @id_notificacion INT,
    @id_recordatorio INT,
    @fecha_hora_notificacion DATETIME
AS
BEGIN
    INSERT INTO notificaciones (id_notificacion, id_recordatorio, fecha_hora_notificacion)
    VALUES (@id_notificacion, @id_recordatorio, @fecha_hora_notificacion);
END;

EXEC AgregarNotificacion @id_notificacion = 1, @id_recordatorio = 1, @fecha_hora_notificacion = '2024-11-20 10:00';
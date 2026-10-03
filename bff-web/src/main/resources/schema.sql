DROP TABLE IF EXISTS resumen_transacciones;
CREATE TABLE IF NOT EXISTS resumen_transacciones (
    id VARCHAR(50) PRIMARY KEY,
    fecha VARCHAR(50),
    monto DOUBLE,
    tipo VARCHAR(50),
    es_anomalia BOOLEAN
);

DROP TABLE IF EXISTS intereses_mensuales;
CREATE TABLE IF NOT EXISTS intereses_mensuales (
    cuenta_id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    saldo DOUBLE,
    edad VARCHAR(10),
    tipo VARCHAR(50),
    saldo_final DOUBLE
);

DROP TABLE IF EXISTS transacciones_anuales;
CREATE TABLE IF NOT EXISTS transacciones_anuales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cuenta_id VARCHAR(50),
    fecha VARCHAR(50),
    transaccion VARCHAR(50),
    monto DOUBLE,
    descripcion VARCHAR(255)
);
DROP TABLE IF EXISTS usuarios;
CREATE TABLE IF NOT EXISTS usuarios (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100),
    role VARCHAR(50)
);
